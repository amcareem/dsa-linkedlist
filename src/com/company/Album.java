package com.company;
/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Song> songs;

    // Constructor: creates a new album with the given name and an empty list of songs.
    public Album(String name) {
        this.albumName = name;
        this.songs = new ArrayList<Song>();
    }
    //Getters
    public String getAlbumName() {
        return this.albumName;
    }
    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    // Methods
    // addSongToAlbum method:
    // Given a song, this method adds the song to the album if it is not already in the album.
    // If the song is already in the album, the method prints a message and returns false.
    // Otherwise, the method adds the song to the album and returns true.
    public boolean addSongToAlbum(Song song) {
        if (findAlbumSong(song) >= 0) {
            System.out.println("Song already on album...");
            return false;
        } else {
            songs.add(song);
            return true;
        }

    }
    // printAlbumDetails method:
    private int findAlbumSong(Song song) {
        return songs.indexOf(song);
    }
    public static void printAlbumDetails(Album album) {
        ArrayList<Song> songs = album.getSongs();
        System.out.println("****" + album.getAlbumName() + "****");
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            System.out.println((i+1) + ". " + song.getName() + " --- " + song.getDuration());
        }
    }
    // retrieveSong method (version 1):
    public static Song retrieveSong(Album album, Song song) {
        ArrayList<Song> availableSongs = album.getSongs();
        int position = album.findAlbumSong(song);
        if (position >= 0) {
            return availableSongs.get(position);
        }
        return null;
    }
    // retrieveSong method (version 2):
    public static Song retrieveSong(Album album, String songName) {
        ArrayList<Song> availableSongs = album.getSongs();
        for (int i = 0; i < availableSongs.size(); i++) {
            Song currentSong = availableSongs.get(i);
            if (currentSong.getName().equals(songName)) {
                return currentSong;
            }
        }
        return null;
    }
}
