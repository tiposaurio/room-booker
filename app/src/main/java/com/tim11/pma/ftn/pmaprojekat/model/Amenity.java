/***********************************************************************
 * Module:  Amenity.java
 * Author:  Shuky
 * Purpose: Defines the Class Amenity
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class Amenity implements Serializable {
   @DatabaseField(id=true)
   private int id;
   @DatabaseField
   private String name;
   @DatabaseField
   private String description;
   @DatabaseField
   private String icon;

   private Set<Hotel> hotels;

   private Set<Room> rooms;

   public Amenity() {}

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

   public String getIcon() {
      return icon;
   }

   public void setIcon(String icon) {
      this.icon = icon;
   }

   public Set<Hotel> getHotels() {
      return hotels;
   }

   public void setHotels(Set<Hotel> hotels) {
      this.hotels = hotels;
   }

   public Set<Room> getRooms() {
      return rooms;
   }

   public void setRooms(Set<Room> rooms) {
      this.rooms = rooms;
   }
}