package com.company;
/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String playlistName;
    private LinkedList<Song> songs;

    // constructor to create a new playlist with a given name
    public Playlist(String name) {
        this.playlistName = name;
        this.songs = new LinkedList<Song>();
    }

    // Getters
    public String getPlaylistName() {
        return playlistName;
    }
    public LinkedList<Song> getSongs() {
        return songs;
    }

    // static method to start playing the playlist
    public static void startPlaylist(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        // get the list of songs in the playlist
        LinkedList<Song> songs = playlist.getSongs();
        // create a ListIterator to navigate through the list of songs
        ListIterator<Song> listIterator = songs.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        // string to display the playlist menu options to the user
        String playlistMenu = "Playlist Menu\n" +
                              "press \n" +
                              "0 - quit playlist and return to main menu\n" +
                              "1 - next song\n" +
                              "2 - previous song\n" +
                              "3 - replay track";
        // check if the playlist is empty, if the playlist is empty, print a message to the user
        if (songs.getFirst().getName().isEmpty()) {
            System.out.println("No songs in selected playlist...");
        } else {
            // if the playlist is not empty, play the first song and display the song name and duration
            Song track = listIterator.next();
            System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
        }

        while(!quit) {
            System.out.println(playlistMenu);
            int action = scanner.nextInt();
            // use a switch statement to handle the user's selection
            switch(action) {
                case 0:
                    System.out.println("Exiting playlist - returning to main menu...");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        // if we were previously going in the opposite direction, skip the current song
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    // play the next song in the playlist if it exists
                    if (listIterator.hasNext()) {
                        Song track = listIterator.next();
                        System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
                    } else {
                        // if there are no more songs in the playlist, print a message and update the direction flag
                        System.out.println("End of Playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        // if we were previously going in the opposite direction, skip the current song
                        if (listIterator.hasPrevious()) {
                           listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        Song track = listIterator.previous();
                        System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
                    } else {
                        // if there are no more songs in the playlist, print a message and update the direction flag
                        System.out.println("Already at beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        // if we are moving forward through the playlist, replay the previous song if it exists
                        if (listIterator.hasPrevious()) {
                            Song track = listIterator.previous();
                            System.out.println("Now replaying " + track.getName() + " ---> " + track.getDuration());
                            goingForward = false;
                        } else {
                            System.out.println("Already at beginning of playlist");
                        }
                    } else {
                        // if we are moving backward through the playlist, replay the next song if it exists
                        if (listIterator.hasNext()) {
                            Song track = listIterator.next();
                            System.out.println("Now replaying " + track.getName() + " ---> " + track.getDuration());
                            goingForward = true;
                        } else {
                            System.out.println("End of Playlist - no more tracks available...");
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
        }

    }
     //Adds a song to the playlist if it is not already in the playlist.
     //Song object to be added to the playlist
    public void addSongToPlaylist(Song song) {
            if (findSong(song) >= 0) {
                System.out.println("Song is already in playlist...");
            } else {
                songs.add(song);
            }
    }
     //Finds the index of a song in the playlist.
     //song the Song object to be searched for in the playlist
     //return the index of the song in the playlist, or -1 if the song is not in the playlist
    public int findSong(Song song) {
        return songs.indexOf(song);
    }
    public static void printSongsInPlaylist(Playlist playlist) {
        ListIterator<Song> songListIterator = playlist.getSongs().listIterator();
        System.out.println("**** " + playlist.getPlaylistName() + " Track List ****");
        int trackNum = 0;
        // Check if the first song in the playlist has an empty name
        if (playlist.getSongs().getFirst().getName().isEmpty()) {
            System.out.println(playlist.getPlaylistName() + " has no tracks...");
        } else {
            while(songListIterator.hasNext()) {
                Song track = songListIterator.next();
                System.out.println((trackNum + 1) + ". " + track.getName() + " --- " + track.getDuration());
                trackNum++;
            }
        }

    }
}
