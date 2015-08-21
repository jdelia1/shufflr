/**
 * Created by Joe Delia on 8/21/2015.
 * Last Edited on 8/21/2015.
 */

import java.util.Queue;
import java.util.LinkedList;

public class Waitlist {
    Queue<Song> waitlist;

    public Waitlist(){
        waitlist = new LinkedList<Song>();
    }

    public void addSongToWaitlist(Song song){
        waitlist.add(song);
    }

    public Song returnSong(){
        return waitlist.remove();
    }

}
