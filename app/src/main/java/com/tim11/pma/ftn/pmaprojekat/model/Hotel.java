/***********************************************************************
 * Module:  Hotel.java
 * Author:  Shuky
 * Purpose: Defines the Class Hotel
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Hotel implements Serializable {
    @DatabaseField(id=true)
   private int id;
    @DatabaseField
   private String name;
    @DatabaseField
   private String description;
    @DatabaseField
   private String website;
    @DatabaseField
   private String phone;
    @DatabaseField
   private int stars;
    @DatabaseField
   private double rating;
    @DatabaseField
   private int numberOfReviews;
    @DatabaseField
   private String imageFilename;

    private Set<Amenity> amenities;

    private Set<Review> reviews;

    @ForeignCollectionField(eager = true)
    private Collection<Room> rooms;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate=true, foreignAutoRefresh=true)
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

   public Collection<Room> getRooms() {
	  return rooms;
   }

   public void setRooms(Collection<Room> rooms) {

	  this.rooms = rooms;
   }

   public Address getAddress() {
	  return address;
   }

   public void setAddress(Address address) {
	  this.address = address;
   }
}