package com.lms.model;

public class Track {

    private int id;
    private String name;

    public Track(){

    }
    public Track(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Track(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Track{" + "id=" + id + ", name=" + name + '}';
    }

}
