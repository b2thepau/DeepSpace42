package org.kodejava.example.spring.collections;

import java.util.*;

public class Album {
    private String title;
    private int year;
    private List<Song> songs = new ArrayList<Song>();
    private Map<String, Publisher> publisher = new HashMap<String, Publisher>();
    private Properties props = new Properties();

    public Album() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setPublisher(Map<String, Publisher> publisher) {
        this.publisher = publisher;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", songs=" + songs +
                ", publisher=" + publisher +
                ", props=" + props +
                '}';
    }
}
