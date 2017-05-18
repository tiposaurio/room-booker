package com.tim11.pma.ftn.pmaprojekat.viewmodel;

import java.util.List;

/**
 * Created by Jan Sulja on 5/18/2017.
 */

public class SearchViewModel {

    private List<Integer> stars;
    private double minRating;
    private double maxRoomPrice;
    private String hotelName;

    public SearchViewModel(List<Integer> stars, double minRating, double maxRoomPrice, String hotelName) {
        this.stars = stars;
        this.minRating = minRating;
        this.maxRoomPrice = maxRoomPrice;
        this.hotelName = hotelName;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }

    public double getMaxRoomPrice() {
        return maxRoomPrice;
    }

    public void setMaxRoomPrice(double maxRoomPrice) {
        this.maxRoomPrice = maxRoomPrice;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Integer> getStars() {
        return stars;
    }

    public void setStars(List<Integer> stars) {
        this.stars = stars;
    }

}
