/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/23/2015.
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Playlist {
    private String name;
    private Integer num_songs;
    private Double length;
    private Boolean can_be_deleted;
    // current_songs are songs that can be played, waitlist songs that have been played.
    private Waitlist waitlist;
    private WaitingList current_songs;
    private List<Song> songs = new ArrayList<Song>();

    public Playlist(String pl_name){
        waitlist = new Waitlist();
        current_songs = new WaitingList();
        name = pl_name;
        num_songs = 0;
        length = 0.0;
        can_be_deleted = true;
    }

    // Constructor for "Master Playlist" which is just the list of all songs.
    public Playlist(){
        waitlist = new Waitlist();
        current_songs = new WaitingList();
        name = "Master Playlist";
        num_songs = 0;
        length = 0.0;
        can_be_deleted = false;  // Cannot delete master playlist, it contains all songs.
    }

    public void playSong(){

    }

    public void addSongToPlaylist(Song song){
        songs.add(song);

        Boolean success = false;
        while (!success) {
            try {
                length += song.getSongLength();
                success = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        num_songs++;
    }

    public void removeSongFromPlaylist(Song song){
        songs.remove(song);
        length -= song.getSongLength();
        num_songs--;
    }

    public String getPlaylistName(){
        return name;
    }

    public Double getPlaylistLength(){
        return length;
    }

    public Integer getNumberOfSongs(){
        return num_songs;
    }

    public Boolean getDelete(){
        return can_be_deleted;
    }

    public List<Song> getPlaylistContents(){
        return songs;
    }

}
