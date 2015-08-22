/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/22/2015.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Shufflr {
    // Declare MediaPlayer object outside of function so garbage collector doesn't erase it while playing.
    private static MediaPlayer mediaPlayer;

    public static void main(String[] args){
        // JFX Panel
        JFXPanel fxPanel = new JFXPanel();
        // Playlist of all songs available. Not able to be deleted.
        Playlist master_playlist = new Playlist();

        String raw_d = "C://Users/Joe/Desktop/TwentyonePilots_Blurryface";  // Local path to music directory
        File d = new File(raw_d);
        List<String> song_list = gatherSongsFromDirectory(d);
        System.out.println(song_list);

        String raw_path = "03_Ride.mp3";  // The local path to your song.
        String song_path = new File(raw_path).toURI().toString();  // Creates useable path to play song.
        Song current_song = new Song(song_path);  // Creates song instance

        // Wait for Song object to be set up before starting the song, so metadata will be available.
        while (!current_song.canRun()){
            try {
                Thread.sleep(1);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        // Once the song is properly set up, play the song.
        playSong(current_song);
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
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }

    private static void playSong(Song song_to_play){
        Media audio = song_to_play.getAudio();
        mediaPlayer = new MediaPlayer(audio);
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {

                System.out.println("Now Playing: " + song_to_play.getName() + " by " + song_to_play.getArtist());
                System.out.println("\tOff the album " + song_to_play.getAlbum());
                System.out.println("\tSong Length: " + song_to_play.getSongLength().toString());
                mediaPlayer.play();
            }
        });

        // Could also play media in this way:
        // AudioClip player = new AudioClip(audio.getSource());
        // player.play();
    }

}
