package OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public String getTotalLengthSongs() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        for (Song song : this.songs) {
            String[] tokens = song.getLength().split(":");
            int currentMinutes = Integer.parseInt(tokens[0]);
            int currentSeconds = Integer.parseInt(tokens[1]);
            minutes += currentMinutes;
            seconds += currentSeconds;

            if (seconds > 59) {
                minutes++;
                seconds -= 60;
            }
            if (minutes > 59) {
                hours++;
                minutes -= 60;
            }
        }
        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
    public int getSongsCount(){
        return  this.songs.size();
    }
}
