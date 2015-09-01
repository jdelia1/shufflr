/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/26/2015.
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Playlist {
    private String name;
    private Integer num_songs, index;
    private Double length;
    private Boolean can_be_deleted;
    // current_songs are songs that can be played, waitlist songs that have been played.
    private Waitlist waitlist = new Waitlist();
    private WaitingList current_songs = new WaitingList();
    private List<Song> songs = new ArrayList<Song>();

    public Playlist(String pl_name, Integer pl_index){
        name = pl_name;
        index = pl_index;
        num_songs = 0;
        length = 0.0;
        can_be_deleted = true;
    }

    // Constructor for "Master Playlist" which is just the list of all songs.
    public Playlist(Integer pl_index){
        name = "Master Playlist";
        index = pl_index;
        num_songs = 0;
        length = 0.0;
        can_be_deleted = false;  // Cannot delete master playlist, it contains all songs.
    }

    public Song getNextSong(){
        Random rand_generator = new Random();
        if(current_songs.getNumSongs() > 0) {
            Integer song_index = rand_generator.nextInt(current_songs.getNumSongs());
            Song song_to_play = current_songs.moveSongAtIndex(song_index);
            // Adds song to the waitlist, and checks to see if waitlist is full.
            // If waitlist is full, move top song in queue back to possible songs list.
            if(waitlist.addSongToWaitlist(song_to_play)){
                Song returned_song = waitlist.popSong();
                current_songs.addSongToWaitingList(returned_song);
            };

            return song_to_play;
        }else{
            return null;
        }
    }

    public void addSongToPlaylist(Song song){
        songs.add(song);
        song.addPlaylist(index);
        current_songs.addSongToWaitingList(song);
        length += song.getSongLength();
        num_songs++;
    }

    public void removeSongFromPlaylist(Song song) {
        songs.remove(song);
        length -= song.getSongLength();
        num_songs--;
    }

    public Waitlist getWaitlist(){
        return waitlist;
    }

    public WaitingList getCurrentSongs(){
        return current_songs;
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