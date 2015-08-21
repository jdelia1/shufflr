/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/21/2015.
 */

import javax.sound.sampled.AudioFileFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Song {
    private String name, artist, album, pts;
    private Media song_player;
    private Integer length;
    private List<Integer> playlists = new ArrayList<Integer>();

    public Song(String path_to_song, String song_name, String song_artist, String song_album, Integer song_length){
        pts = path_to_song;  // Local path to song
        song_player = new Media(pts);
        name = song_name;
        artist = song_artist;
        album = song_album;
        length = song_length;
    }

    // Song has been added to a playlist
    public void addPlaylist(Integer pl_index){
        playlists.add(pl_index);
    }

    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public String getAlbum(){
        return album;
    }

    public Integer getLength(){
        return length;
    }

    public List<Integer> getPlaylists(){
        return playlists;
    }

}
