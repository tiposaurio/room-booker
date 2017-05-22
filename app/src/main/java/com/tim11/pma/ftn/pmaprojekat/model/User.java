package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

    private int id;

    private String firstname;

    private String lastname;

    private String email;

    private Set<Reservation> reservations;

    private Set<Review> reviews;

    private Address address;

    private FBUser fbUser;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FBUser getFbUser() {
        return fbUser;
    }

    public void setFbUser(FBUser fbUser) {
        this.fbUser = fbUser;
    }
}
