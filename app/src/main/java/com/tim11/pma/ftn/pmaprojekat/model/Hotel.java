package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuky on 4/19/2017.
 */

public class Hotel implements Serializable{


    private String name;
    private String address;
    private int stars;
    private int reviews;
    private double rating;
    private String website;
    private String imagUrl;

    public Hotel() {
    }

    public Hotel(String name, String address, int stars, int reviews, double rating, String website, String imagUrl) {
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.reviews = reviews;
        this.rating = rating;
        this.website = website;
        this.imagUrl = imagUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImagUrl() {
        return imagUrl;
    }

    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
    }

    public static ArrayList<Hotel> getHotelsMock(){

        ArrayList<Hotel> hotels = new ArrayList<>();

        Hotel h1 = new Hotel("Hotel 1","Bulevar oslobodjenja 45 Novi Sad",4,456,9.8,"www.hotel1.com","images/hotel1.jpg");
        Hotel h2 = new Hotel("Hotel 2","Narodnog Fronta 78 Novi Sad",3,456,9.8,"www.hotel1.com","images/hotel1.jpg");
        Hotel h3 = new Hotel("Hotel 3","Šekspirova 23 Novi Sad",2,456,9.8,"www.hotel1.com","images/hotel1.jpg");

        hotels.add(h1);
        hotels.add(h2);
        hotels.add(h3);

        hotels.add(h1);
        hotels.add(h2);
        hotels.add(h3);

        hotels.add(h1);
        hotels.add(h2);
        hotels.add(h3);

        hotels.add(h1);
        hotels.add(h2);
        hotels.add(h3);

        return hotels;

    }

    @Override
    public String toString() {
        return name;
    }
}
