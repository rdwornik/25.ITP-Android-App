package com.aplikacjaitp.robert.aplikacjaitp.model;

import java.io.Serializable;



/**
 * Created by robert on 1/30/18.
 */

public class Company implements Serializable {
    private String logoLink;
    private String day;
    private String name;
    private String description;
    private String standNumber;
    private String faculties;

    public Company() {
    }

    public Company(String logoLink, String day, String name, String description, String standNumber, String faculties) {
        this.logoLink = logoLink;
        this.day = day;
        this.name = name;
        this.description = description;
        this.standNumber = standNumber;
        this.faculties = faculties;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public String getDay() {
        return day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getStandNumber() {
        return standNumber;
    }

    public String getFaculties() {
        return faculties;
    }


}
