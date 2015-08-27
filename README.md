# Shufflr
Shufflr is a Java based music player app that features vastly expanded shuffling functionality. Eventually the player will allow the user to customize whether they want to add songs back into a shuffled playlist, and the frequency that those songs are re-added into the playlist.

### Implemented Features
 - Shufflr will take a single file path, and recursively grab all .mp3 files within that directory, and all subdirectories.
 - Shufflr will create Song instances of every .mp3 file it grabs, and put them into a master playlist.
 - Shufflr will play a given number of songs, or until the songs run out.
 - Shufflr will send songs between a playlists waitlist (songs that have been played) and waitinglist (songs that can be played), and will return songs from the waitlist to the waiting list if the waitlist is full (waitlist size can be set by the user).

### To-do List
The below features are to be completed in the immediate future:
 - Begin GUI implementation
 - Allow for user to skip song

### Future Features
The below features are more distant or vague goals:
 - Implement GUI
 - Play songs in a playlist in succession
 - User controls for shuffle
