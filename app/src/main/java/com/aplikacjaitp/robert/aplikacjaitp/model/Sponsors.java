package com.aplikacjaitp.robert.aplikacjaitp.model;

/**
 * Created by robert on 2/14/18.
 */

public class Sponsors {
    private String description;
    private String logoLink;
    private String name;
    private String type;

    public Sponsors() {
    }

    public Sponsors(String description, String logoLink, String name, String type) {
        this.description = description;
        this.logoLink = logoLink;
        this.name = name;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
