package com.tim11.pma.ftn.pmaprojekat.dto;

import java.io.Serializable;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */

public class FbUserReviewDTO implements Serializable {

    private String description;

    private String fbProfileId;

    private int rating;

    private int reservationId;

    public FbUserReviewDTO() {
    }

    public FbUserReviewDTO(String description, String fbProfileId, int rating, int reservationId) {
        this.description = description;
        this.fbProfileId = fbProfileId;
        this.rating = rating;
        this.reservationId = reservationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFbProfileId() {
        return fbProfileId;
    }

    public void setFbProfileId(String fbProfileId) {
        this.fbProfileId = fbProfileId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
