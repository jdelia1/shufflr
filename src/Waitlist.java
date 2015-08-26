/**
 * Created by Joe Delia on 8/21/2015.
 * Last Edited on 8/26/2015.
 */

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class Waitlist {
    Integer max_songs; // Max Songs set to 1 by default.
    Queue<Song> waitlist;
    Integer songs_in_queue;

    public Waitlist(){
        waitlist = new LinkedList<Song>();
        songs_in_queue = 0;
        max_songs = 1;
    }

    public Waitlist(Integer max){
        waitlist = new LinkedList<Song>();
        songs_in_queue = 0;
        max_songs = max;
    }

    // Function to add a song to the waitlist
    public Boolean addSongToWaitlist(Song song){
        waitlist.add(song);
        songs_in_queue++;
        return songs_in_queue > max_songs;
    }

    public void setMaxSongs(Integer max){
        max_songs = max;
    }

    public Song popSong(){
        return waitlist.poll();
    }

    public Queue<Song> getWaitlist(){
        return waitlist;
    }

}