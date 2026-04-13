import java.util.*;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void displaySong() {
        System.out.println(title + " by " + artist);
    }
}

class Playlist {
    private Song[] songs;
    private int count;

    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    public void addSong(Song song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    public void shufflePlaylist() {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int j = rand.nextInt(count);
            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }
    }

    public void displayPlaylist() {
        System.out.println("\nPlaylist Queue:");
        for (Song song : songs) {
            if (song != null) {
                song.displaySong();
            }
        }
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song title: ");
            String title = sc.nextLine();

            System.out.print("Enter artist name: ");
            String artist = sc.nextLine();

            playlist.addSong(new Song(title, artist));
        }

        playlist.displayPlaylist();
        playlist.shufflePlaylist();
        System.out.println("\nAfter Shuffling:");
        playlist.displayPlaylist();

        sc.close();
    }
}