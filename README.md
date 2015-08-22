# Shufflr
Shufflr is a Java based music player app that features vastly expanded shuffling functionality. Eventually the player will allow the user to customize whether they want to add songs back into a shuffled playlist, and the frequency that those songs are re-added into the playlist.

### Implemented Features
 - Shufflr will take a single file path, and recursively grab all .mp3 files within that directory, and all subdirectories.
 - Shufflr will take a single .mp3 file's path, and play only that song (independent functionality of the recursive grab).
   - Shufflr will create a Song instance, which records the metadata available from the .mp3 file, its length, and create a Media object of the .mp3 file, that can be played by a MediaPlayer object.
 - Shufflr will print to the console when the .mp3 file is done playing.
 - Partially implemented Playlist class
 - Partially implemented Waitlist class
 
### To-do List
The below features are to be completed in the immediate future:
 - Create Song instances of all paths gathered by gatherSongsFromDirectory().
 - Add Song instances to Master Playlist
 - Create NotPlayed class (similar to Waitlist, but holds songs that have yet to be played)
 - Make Playlist contain a Waitlist object and a NotPlayed object that can interact with each other (i.e. send songs between)
 
### Future Features
The below features are more distant or vague goals:
 - Implement GUI
 - Play songs in a playlist in succession
 - Play songs in a playlist randomly (shuffle)
 - User controls for shuffle
