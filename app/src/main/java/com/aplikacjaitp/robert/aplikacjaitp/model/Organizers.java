package com.aplikacjaitp.robert.aplikacjaitp.model;

/**
 * Created by robert on 1/30/18.
 */

public class Organizers {
    private String name;
    private String description;
    private String photoLink;

    public Organizers() {
    }

    public Organizers(String name, String description, String photoLink) {
        this.name = name;
        this.description = description;
        this.photoLink = photoLink;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
