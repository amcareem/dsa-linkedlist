package com.company;
/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
import java.util.ArrayList;

public class Collection {
    private String collectionName;
    private ArrayList<Album> albumCollection;
    private ArrayList<Playlist> playlistCollection;

    //The constructor Collection(String name) initializes a new collection with the given name and creates empty ArrayList objects to store albums and playlists.
    public Collection(String name) {
        this.collectionName = name;
        this.albumCollection = new ArrayList<Album>();
        this.playlistCollection = new ArrayList<Playlist>();
    }

    // Getters
    public ArrayList<Album> getAlbums() {
        return this.albumCollection;
    }
    public ArrayList<Playlist> getPlaylists() {
        return this.playlistCollection;
    }

    // method adds the given album to the collection if it is not already present. It returns true if the album is added successfully and false otherwise.
    public boolean addAlbumToCollection(Album album) {
        if (retrieveAlbum(album.getAlbumName()) == null) {
            this.albumCollection.add(album);
            return true;
        } else {
            return false;
        }

    }
    //adds the given playlist to the collection if it is not already present. It returns true if the playlist is added successfully and false otherwise.
    public boolean addPlaylistToCollection(Playlist playlist) {
        if (retrievePlaylist(playlist.getPlaylistName()) == null) {
            this.playlistCollection.add(playlist);
            return true;
        } else {
            return false;
        }

    }
    //method searches the collection for an album with the given name and returns it if found. If no such album is found, it returns null.
    public Album retrieveAlbum(String albumName) {
        for (int i = 0; i < albumCollection.size(); i++) {
            Album currentAlbum = albumCollection.get(i);
            if (currentAlbum.getAlbumName().equals(albumName)) {
                return currentAlbum;
            }
        }
        return null;
    }
    //method searches the collection for a playlist with the given name and returns it if found. If no such playlist is found, it returns null.
    public Playlist retrievePlaylist(String playlistName) {
        for (int i = 0; i < playlistCollection.size(); i++) {
            Playlist currentPlaylist = playlistCollection.get(i);
            if (currentPlaylist.getPlaylistName().equals(playlistName)) {
                return currentPlaylist;
            }
        }
        return null;
    }
}
