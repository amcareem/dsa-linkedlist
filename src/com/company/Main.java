package com.company;
/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        // Create a new collection with the name "UserCollection"
        Collection newCollection = new Collection("UserCollection");
        // Start the music application
        startMusicApplication();
        // Print out the available actions
        availableActions();
        // The loop will run until the quit flag is set to true
        while (!quit) {
            // Prompt the user to enter an action
            System.out.println("\nEnter action: (9 to display all actions)");
            // Read the user's action
            int action = scanner.nextInt();
            scanner.nextLine();
            // Check the action and perform the corresponding task
            switch(action) {
                case 0:
                    // Action 0: exit the program
                    System.out.println("Exiting music application...");
                    quit = true;
                    break;
                case 1:
                    // Action 1: create a new album in the collection
                    createNewAlbum(newCollection);
                    break;
                case 2:
                    // Action 2: add a song to an album in the collection
                    addSongToAlbum(newCollection);
                    break;
                case 3:
                    // Action 3: create a new playlist in the collection
                    createNewPlaylist(newCollection);
                    break;
                case 4:
                    // Action 4: add a song to a playlist in the collection
                    addSongToPlaylist(newCollection);
                    break;
                case 5:
                    // Action 5: print the songs in an album in the collection
                    printAlbumSongs(newCollection);
                    break;
                case 6:
                    // Action 6: print the songs in a playlist in the collection
                    printPlaylistSongs(newCollection);
                    break;
                case 7:
                    // Action 7: start playing a playlist in the collection
                    startPlaylist(newCollection);
                    break;
                case 8:
                    // Action 8: print the albums in the collection
                    printAlbumsInCollection(newCollection);
                    break;
                case 9:
                    // Action 9: print the available actions
                    availableActions();
                    break;
                default:
                    // If the action is not recognized, print an error message and exit the program
                    System.out.println("Action not recognized....");
                    quit = true;
                    break;
            }
        }

    }

    private static void startMusicApplication() {
        System.out.println("Opening Music Application...");
    }
    private static void availableActions() {
        System.out.println("Music Application Actions" + "\n" +
                "0 - exit music application" + "\n" +
                "1 - create new Album" + "\n" +
                "2 - create new Song and add to Album" + "\n" +
                "3 - create new Playlist" + "\n" +
                "4 - add song to Playlist" + "\n" +
                "5 - print Album Songs" + "\n" +
                "6 - print Playlist Songs" + "\n" +
                "7 - start Playlist" + "\n" +
                "8 - print Albums in Collection" + "\n" +
                "9 - show all the actions"
        );
    }
    // This method creates a new album in the given collection
    private static void createNewAlbum(Collection collection) {
        System.out.println("Name your album");
        String albumName = scanner.nextLine();
        Album newAlbum = new Album(albumName);
        collection.addAlbumToCollection(newAlbum);
    }
    // This method adds a song to an album in the given collection
    private static void addSongToAlbum(Collection collection) {
        System.out.println("Provide the Album you want to add to");
        String albumName = scanner.nextLine();
        Album albumForAddition = collection.retrieveAlbum(albumName);
        // If the album is not found in the collection, print an error message
        if (albumForAddition == null) {
            System.out.println("Album you provided is not in your collection - try creating it first...");
        } else {
            // If the album is found, prompt the user to enter the name of the song they want to add
            System.out.println("Provide the Song Name you want to add this album");
            String songName = scanner.nextLine();
            System.out.println("Provide the duration of this song");
            String songDuration = scanner.nextLine();
            Song songToAdd = new Song(songName, songDuration);
            albumForAddition.addSongToAlbum(songToAdd);
        }
    }
    // This method creates a new playlist in the given collection
    private static void createNewPlaylist(Collection collection) {
        System.out.println("Create a name for your Playlist");
        String playlistName = scanner.nextLine();
        Playlist newPlaylist = new Playlist(playlistName);
        collection.addPlaylistToCollection(newPlaylist);
    }
    // This method adds a song to a playlist in the given collection
    private static void addSongToPlaylist(Collection collection) {
        System.out.println("What playlist do you want to add to?");
        String playlistName = scanner.nextLine();
        // Retrieve the playlist from the collection
        Playlist playlist = collection.retrievePlaylist(playlistName);
        // If the playlist is not found in the collection, print an error message
        if (playlist == null) {
            System.out.println("Playlist doesn't exist...");
        } else {
            System.out.println("What album is your song from?");
            String albumName = scanner.nextLine();
            Album album = collection.retrieveAlbum(albumName);
            if (album == null) {
                System.out.println("That album is not in your collection...");
            } else {
                System.out.println("What song do you want to add?");
                String songToAdd = scanner.nextLine();
                Song song = Album.retrieveSong(album, songToAdd);
                if (song == null) {
                    System.out.println("Song is not on that album...");
                } else {
                    playlist.addSongToPlaylist(song);
                }
            }
        }
    }
    // This method prints the songs in an album in the given collection
    private static void printAlbumSongs(Collection collection) {
        // Prompt the user to enter the name of the album they want to see the track list for
        System.out.println("Which album do you want to see a track list for?");
        String albumName = scanner.nextLine();
        Album album = collection.retrieveAlbum(albumName);
        // If the album is not found in the collection, print an error message
        if (album == null) {
            System.out.println("Album not in your collection...");
        } else {
            // If the album is found, print the details of the album (including the track list)
            Album.printAlbumDetails(album);
        }
    }
    // This method prints the songs in a playlist in the given collection
    private static void printPlaylistSongs(Collection collection) {
        System.out.println("Which Playlist do you want to see a track list for?");
        String playlistName = scanner.nextLine();
        Playlist playlist = collection.retrievePlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist does not exist...");
        } else {
            Playlist.printSongsInPlaylist(playlist);
        }
    }
    // This method starts playing a playlist in the given collection
    private static void startPlaylist(Collection collection) {
        System.out.println("Which Playlist do you want to listen to?");
        String playlistName = scanner.nextLine();
        Playlist playlist = collection.retrievePlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist does not exist...");
        } else {
            // If the playlist is found, start playing the playlist
            Playlist.startPlaylist(playlist);
        }
    }
    // This method prints the albums in the given collection
    private static void printAlbumsInCollection(Collection collection) {
        // Get the list of albums in the collection
        ArrayList<Album> albums = collection.getAlbums();
        // If there are albums in the collection, print the list of albums
        if (albums.size() > 0) {
            System.out.println("****Albums in Collection****");
            for (int i = 0; i < albums.size(); i++) {
                System.out.println((i + 1) + ". " + albums.get(i).getAlbumName());
            }
        } else {
            System.out.println("****No Albums in Collection****");
        }
    }
}
