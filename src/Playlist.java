/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/20/2015.
 */

import java.util.ArrayList;
import java.util.List;


public class Playlist {
    private String name;
    private Integer length, num_songs;
    private Boolean can_be_deleted;
    private List<Song> songs = new ArrayList<Song>();

    public Playlist(String pl_name){
        name = pl_name;
        length = 0;
        num_songs = 0;
        can_be_deleted = true;
    }

    public Playlist(){
        name = "Master Playlist";
        length = 0;
        num_songs = 0;
        can_be_deleted = false;  // Cannot delete master playlist, it contains all songs.
    }

    public void addSongToPlaylist(Song song){
        songs.add(song);
        length += song.getLength();
        num_songs++;
    }

    public void removeSongFromPlaylist(Song song){
        songs.remove(song);
        length -= song.getLength();
        num_songs--;
    }

    public String getPlaylistName(){
        return name;
    }

    public Integer getPlaylistLength(){
        return length;
    }

    public Integer getNumberOfSongs(){
        return num_songs;
    }

    public List<Song> getPlaylistContents(){
        return songs;
    }

}
