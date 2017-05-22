/***********************************************************************
 * Module:  Hotel.java
 * Author:  Shuky
 * Purpose: Defines the Class Hotel
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;
import java.util.Set;

public class Hotel implements Serializable {

   private int id;

   private String name;

   private String description;

   private String website;

   private String phone;

   private int stars;

   private double rating;

   private int numberOfReviews;

   private String imageFilename;

   private Set<Amenity> amenities;

   private Set<Review> reviews;

   private Set<Room> rooms;

   private Address address;

   public Hotel() {}

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

   public String getDescription() {
	  return description;
   }

   public void setDescription(String description) {
	  this.description = description;
   }

   public String getWebsite() {
	  return website;
   }

   public void setWebsite(String website) {
	  this.website = website;
   }

   public String getPhone() {
	  return phone;
   }

   public void setPhone(String phone) {
	  this.phone = phone;
   }

   public int getStars() {
	  return stars;
   }

   public void setStars(int stars) {
	  this.stars = stars;
   }

   public double getRating() {
	  return rating;
   }

   public void setRating(double rating) {
	  this.rating = rating;
   }

   public int getNumberOfReviews() {
	  return numberOfReviews;
   }

   public void setNumberOfReviews(int numberOfReviews) {
	  this.numberOfReviews = numberOfReviews;
   }

   public String getImageFilename() {
	  return imageFilename;
   }

   public void setImageFilename(String imageFilename) {
	  this.imageFilename = imageFilename;
   }

   public Set<Amenity> getAmenities() {
	  return amenities;
   }

   public void setAmenities(Set<Amenity> amenities) {
	  this.amenities = amenities;
   }

   public Set<Review> getReviews() {
	  return reviews;
   }

   public void setReviews(Set<Review> reviews) {
	  this.reviews = reviews;
   }

   public Set<Room> getRooms() {
	  return rooms;
   }

   public void setRooms(Set<Room> rooms) {
	  this.rooms = rooms;
   }

   public Address getAddress() {
	  return address;
   }

   public void setAddress(Address address) {
	  this.address = address;
   }
}