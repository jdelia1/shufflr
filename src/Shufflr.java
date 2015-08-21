/**
 * Created by Joe Delia on 8/20/2015.
 * Last Edited on 8/20/2015.
 */
import java.util.ArrayList;


public class Shufflr {

    public static void main(String[] args){
        // Playlist of all songs available. Not able to be deleted.
        Playlist master_playlist = new Playlist();

        /* Songs are added back in to the song pool by:
        (0) Fixed Number (DEFAULT)
        (1) Time Passed
        (2) Percentage of total playlist */
        int add_songs_style = 0;
        int num_songs = -1, num_seconds = -1, num_percentage = -1;

        if(add_songs_style == 0){
            num_songs = 20; // Start adding songs back to list after 20 plays
        }else if(add_songs_style == 1){
            num_seconds = 1800; // Start adding songs back after 30 minutes
        }else{
            num_percentage = 50; // Start adding songs back after 50% of playlist
        }
    }

}
