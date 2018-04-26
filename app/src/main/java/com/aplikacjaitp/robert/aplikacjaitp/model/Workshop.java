package com.aplikacjaitp.robert.aplikacjaitp.model;

/**
 * Created by robert on 2/14/18.
 */

public class Workshop {
    private String description;
    private String name;
    private String room;
    private int day;
    private String time;

    public Workshop() {
    }

    public Workshop(String description,  String name, String room, int day, String time) {
        this.description = description;;
        this.name = name;
        this.room = room;
        this.day = day;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
