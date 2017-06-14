/***********************************************************************
 * Module:  Address.java
 * Author:  Shuky
 * Purpose: Defines the Class Address
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Set;

public class Address implements Serializable {


   @DatabaseField(generatedId = true,allowGeneratedIdInsert=true)
   private long id;
   @DatabaseField
   private String street;
   @DatabaseField
   private String number;
   @DatabaseField
   private String city;
   @DatabaseField
   private String country;
   @DatabaseField
   private double latitude;
   @DatabaseField
   private double longitude;

   private Set<Hotel> hotels;

   private Set<User> users;

   private Address() {}

   private long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public double getLatitude() {
      return latitude;
   }

   public void setLatitude(double latitude) {
      this.latitude = latitude;
   }

   public double getLongitude() {
      return longitude;
   }

   public void setLongitude(double longitude) {
      this.longitude = longitude;
   }

   public Set<Hotel> getHotels() {
      return hotels;
   }

   public void setHotels(Set<Hotel> hotels) {
      this.hotels = hotels;
   }

   public Set<User> getUsers() {
      return users;
   }

   public void setUsers(Set<User> users) {
      this.users = users;
   }

   @Override
   public String toString() {
      String retValue = "";
      if (street != null) {
         retValue = retValue.concat(street);
         if (number != null) {
            retValue = retValue.concat(" " + number);
         }
      }
      if (city != null) {
         if (retValue.length() != 0) {
            retValue = retValue.concat(" ");
         }
         retValue = retValue.concat(city);
      }
      if (country != null) {
         if (retValue.length() != 0) {
            retValue = retValue.concat(" ");
         }
         retValue = retValue.concat(country);
      }
      return retValue;
   }
}