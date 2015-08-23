# Shufflr
Shufflr is a Java based music player app that features vastly expanded shuffling functionality. Eventually the player will allow the user to customize whether they want to add songs back into a shuffled playlist, and the frequency that those songs are re-added into the playlist.

### Implemented Features
 - Shufflr will take a single file path, and recursively grab all .mp3 files within that directory, and all subdirectories.
 - Shufflr will create Song instances of every .mp3 file it grabs, and put them into a master playlist.
 - Shufflr will play a specific number of the Song objects it has randomly, without moving them out of the play queue.
 - Partially implemented Playlist class
 - Partially implemented Waitlist class
 
### To-do List
The below features are to be completed in the immediate future:
 - Create NotPlayed class (similar to Waitlist, but holds songs that have yet to be played)
 - Make Playlist contain a Waitlist object and a NotPlayed object that can interact with each other (i.e. send songs between)
 - Control the flow of songs between the Waitlist and NotPlayed within a Playlist
 
### Future Features
The below features are more distant or vague goals:
 - Implement GUI
 - Play songs in a playlist in succession
 - Play songs in a playlist randomly (shuffle)
 - User controls for shuffle
