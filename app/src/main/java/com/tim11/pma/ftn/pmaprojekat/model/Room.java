/***********************************************************************
 * Module:  Room.java
 * Author:  Shuky
 * Purpose: Defines the Class Room
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class Room implements Serializable {

   @DatabaseField(generatedId = true,allowGeneratedIdInsert=true)
   private int id;
   @DatabaseField
   private String name;
   @DatabaseField
   private int count;
   @DatabaseField
   private int available;
   @DatabaseField
   private String description;

   private Set<RoomBed> roomBeds;


   private Set<Amenity> amenities;
   private Set<Reservation> reservations;

   @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
   private Hotel hotel;

   @DatabaseField(foreign = true, foreignAutoCreate=true, foreignAutoRefresh=true)
   private Price price;

   public Room() {}

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

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getAvailable() {
      return available;
   }

   public void setAvailable(int available) {
      this.available = available;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Set<RoomBed> getRoomBeds() {
      return roomBeds;
   }

   public void setRoomBeds(Set<RoomBed> roomBeds) {
      this.roomBeds = roomBeds;
   }

   public Set<Amenity> getAmenities() {
      return amenities;
   }

   public void setAmenities(Set<Amenity> amenities) {
      this.amenities = amenities;
   }

   public Set<Reservation> getReservations() {
      return reservations;
   }

   public void setReservations(Set<Reservation> reservations) {
      this.reservations = reservations;
   }

   public Hotel getHotel() {
      return hotel;
   }

   public void setHotel(Hotel hotel) {
      this.hotel = hotel;
   }

   public Price getPrice() {
      return price;
   }

   public void setPrice(Price price) {
      this.price = price;
   }

}