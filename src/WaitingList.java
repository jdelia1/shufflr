/**
 * Created by Joe Delia on 8/23/2015.
 * Last Edited on 8/26/2015.
 */

import java.util.List;
import java.util.ArrayList;


public class WaitingList {
    List<Song> waitingList;
    Integer songs_in_list;

    public WaitingList(){
        waitingList = new ArrayList<Song>();
        songs_in_list = 0;
    }

    public void addSongToWaitingList(Song song){
        waitingList.add(song);
        songs_in_list++;
    }

    public Integer getNumSongs(){
        return songs_in_list;
    }

    // Returns the song at index without removing the song
    public Song getSongAtIndex(Integer i){
        return waitingList.get(i);
    }

    // Returns the song at index, and removes it from list
    public Song moveSongAtIndex(Integer i){
        Song song_to_remove = waitingList.get(i);
        waitingList.remove(song_to_remove);
        songs_in_list--;
        return song_to_remove;
    }

    public List<Song> getWaitingList(){
        return waitingList;
    }
}