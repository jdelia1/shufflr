/**
 * Created by Joe Delia on 8/21/2015.
 * Last Edited on 8/23/2015.
 */

import java.util.Queue;
import java.util.LinkedList;


public class Waitlist {
    Integer DEFAULT = 4;
    Queue<Song> waitlist;
    Integer songs_in_queue, max_songs;

    public Waitlist(){
        waitlist = new LinkedList<Song>();
        max_songs = DEFAULT;
    }

    public Waitlist(Integer max){
        waitlist = new LinkedList<Song>();
        max_songs = max;
    }

    public void addSongToWaitlist(Song song){
        waitlist.add(song);
        songs_in_queue++;
        if(songs_in_queue > max_songs){
            this.returnSong();
        }
    }

    public Song returnSong(){
        return waitlist.remove();
    }

}
