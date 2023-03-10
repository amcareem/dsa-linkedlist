package com.company;
/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
public class Song {
    private String name;
    private String duration;

    // Constructor: creates a new song with the given name and duration.
    public Song(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
    // Getter
    public String getName() {
        return this.name;
    }
    public String getDuration() {
        return this.duration;
    }
    // Method
    public static Song createSong(String name, String duration) {
        Song newSong = new Song(name, duration);
        return newSong;
    }
}
