package OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(reader.readLine());

        SongDatabase songDatabase=new SongDatabase();

        while (n-- >0) {
            String[] tokens = reader.readLine().split(";");

            try {
                Song song = new Song(tokens[0],tokens[1],tokens[2]);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Songs added: "+songDatabase.getSongsCount());
        System.out.println(songDatabase.getTotalLengthSongs());

    }
}
