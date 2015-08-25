/**
 * Created by Joe Delia on 8/21/2015.
 * Last Edited on 8/24/2015.
 */

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class Waitlist {
    Integer DEFAULT = 4;
    Queue<Song> waitlist;
    Integer songs_in_queue, max_songs;

    public Waitlist(){
        waitlist = new LinkedList<Song>();
        songs_in_queue = 0;
        max_songs = DEFAULT;
    }

    public Waitlist(Integer max){
        waitlist = new LinkedList<Song>();
        songs_in_queue = 0;
        max_songs = max;
    }

    public Boolean addSongToWaitlist(Song song){
        waitlist.add(song);
        songs_in_queue++;
        return songs_in_queue > DEFAULT;
    }

    public Song popSong(){
        return waitlist.poll();
    }

    public Queue<Song> getWaitlist(){
        return waitlist;
    }

}