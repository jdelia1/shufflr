/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/21/2015.
 */

import java.io.*;
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

        String raw_path = "";  // The local path to your song.
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

    public static void gatherSongsFromDirectory(String directory){

    }

    public static void playSong(Song song_to_play){
        Media audio = song_to_play.getAudio();
        mediaPlayer = new MediaPlayer(audio);
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {

                System.out.println("Now Playing: " + song_to_play.getName() + " by " + song_to_play.getArtist());
                System.out.println("\tOff the album " + song_to_play.getAlbum());
                System.out.println("\tSong Length: " + song_to_play.getSongLength().toSeconds() + " seconds");
                mediaPlayer.play();
            }
        });

        // Could also play media in this way:
        // AudioClip player = new AudioClip(audio.getSource());
        // player.play();
    }

}
