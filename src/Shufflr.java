/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 9/1/2015.
 */

import java.io.*;
import java.util.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Shufflr {
    // Declare MediaPlayer object outside of function so garbage collector doesn't erase it while playing.
    private static MediaPlayer mediaPlayer;

    public static void main(String[] args){
        // Shufflr Window
        ShufflrWindow shufflr = new ShufflrWindow();
        // JFX Panel
        JFXPanel fxPanel = new JFXPanel();
        // Playlist of all songs available. Not able to be deleted.
        Playlist master_playlist = new Playlist(0);
        // Exit
        Integer EXIT = 3;  // Ends shufflr after 3 songs by default. Change value for more/less.

        // Gather song paths from a directory
        String raw_d = "";  // Local path to music directory
        File d = new File(raw_d);
        List<String> song_list = gatherSongsFromDirectory(d);

        // Add all songs from directory to the master playlist
        for (String song_path : song_list){
            Song temp_song = new Song(song_path);
            while (!temp_song.isReady()){
                try { Thread.sleep(1);}
                catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
            }
            master_playlist.addSongToPlaylist(temp_song);
        }

        for (int i=0; i<EXIT; i++) {
            Song current_song = master_playlist.getNextSong();
            System.out.println("Songs that can be played:");
            for (int j=0; j<master_playlist.getCurrentSongs().getWaitingList().size(); j++){
                System.out.println(master_playlist.getCurrentSongs().getWaitingList().get(j).getName());
            }
            // Play the next song, unless no song exists (no songs left in playable list)
            if(current_song != null) { playSong(current_song); }
            else{ break; }
        }

        // If everything runs correctly, abort all threads and end with no error.
        System.exit(0);
    }

    private static List<String> gatherSongsFromDirectory(File base_directory, List<String> files){
        if (".mp3".equals(fileExtension(base_directory))){
            files.add(base_directory.toString());
        }
        if (base_directory.isDirectory()) {
            String[] children = base_directory.list();
            for (int i = 0; i < children.length; i++) {
                gatherSongsFromDirectory(new File(base_directory, children[i]), files);
            }
        }

        return files;
    }

    private static List<String> gatherSongsFromDirectory(File base_directory){
        List<String> files = new ArrayList<String>();
        return gatherSongsFromDirectory(base_directory, files);
    }

    private static String fileExtension(File file) {
        String name = file.getName();
        try { return name.substring(name.lastIndexOf(".")); }
        catch (Exception e) { return null; }
    }

    private static void playSong(Song song_to_play){
        Media audio = song_to_play.getAudio();
        mediaPlayer = new MediaPlayer(audio);

        System.out.println("Now Playing: " + song_to_play.getName() + " by " + song_to_play.getArtist());
        System.out.println("\tOff the album " + song_to_play.getAlbum());
        System.out.println("\tSong Length - " + milliToReadable(song_to_play.getSongLength()));

        Double timer = 0.0;
        mediaPlayer.play();
        while (timer < song_to_play.getSongLength()/1000){
            try {
                Thread.sleep(1000);
                timer += 1.0;
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        // Could also play media in this way:
        // AudioClip player = new AudioClip(audio.getSource());
        // player.play();
    }

    private static String milliToReadable(Double millis){
        Double song_raw_time = millis/1000.0;
        Integer song_minutes = song_raw_time.intValue()/60;
        Integer song_seconds = song_raw_time.intValue()%60;
        String seconds;
        if (song_seconds < 10){
            seconds = "0" + Integer.toString(song_seconds);
        }else{
            seconds = Integer.toString(song_seconds);
        }

        return song_minutes + ":" + seconds;
    }

}