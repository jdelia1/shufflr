/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/22/2015.
 */

import javax.sound.sampled.AudioFileFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Song {
    private String name, artist, album, pts, genre, composer;
    private Integer track, total_tracks;
    private Media song_audio;
    private Duration length;
    private Boolean run = false;
    private List<Integer> playlists = new ArrayList<Integer>();

    public Song(String path_to_song){
        String raw_pts = path_to_song;
        pts = new File(raw_pts).toURI().toString();
        song_audio = new Media(pts);
        MediaPlayer mediaPlayer = new MediaPlayer(song_audio);
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {

                length = song_audio.getDuration();
                name = song_audio.getMetadata().get("title").toString();
                artist = song_audio.getMetadata().get("artist").toString();
                album = song_audio.getMetadata().get("album").toString();
                track = (Integer) song_audio.getMetadata().get("track number");
                total_tracks = (Integer) song_audio.getMetadata().get("track count");
                genre = song_audio.getMetadata().get("genre").toString();
                composer = song_audio.getMetadata().get("composer").toString();
                run = true;

            }
        });

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

    public String getGenre() {
        return genre;
    }

    public String getComposer() {
        return composer;
    }

    public Integer getTrackNumber() {
        return track;
    }

    public Integer getTotalTracks() {
        return total_tracks;
    }

    // Returns length of song in default duration form
    public Duration getDuration() {
        return length;
    }

    // Returns length of song in usable double form
    public Double getSongLength(){
        String[] length_str = length.toString().split("\\s+");
        Double length_float;
        try{
            length_float = Double.parseDouble(length_str[0]);
        }catch (NumberFormatException e) {
            length_float = -1.0;  // Failed, duration couldn't convert to int
        }

        return length_float;
    }

    public Boolean canRun(){
        return run;
    }

    public Media getAudio(){
        return song_audio;
    }

    public List<Integer> getPlaylists(){
        return playlists;
    }

}
