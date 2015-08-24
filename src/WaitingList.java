/**
 * Created by Joe Delia on 8/23/2015.
 * Last Edited on 8/23/2015.
 */

import java.util.List;
import java.util.ArrayList;


public class WaitingList {
    Integer DEFAULT = 4;
    List<Song> waitingList;
    Integer songs_in_queue, max_songs;

    public WaitingList(){
        waitingList = new ArrayList<Song>();
        max_songs = DEFAULT;
    }

    public void addSongToWaitingList(Song song){
        waitingList.add(song);
        songs_in_queue++;
    }
}