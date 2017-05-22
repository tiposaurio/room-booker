/***********************************************************************
 * Module:  Reservation.java
 * Author:  Shuky
 * Purpose: Defines the Class Reservation
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

   private int id;

   private Date startDate;

   private Date endDate;

   private double price;

   private Room room;

   private User user;

   public Reservation() {}

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Date getStartDate() {
      return startDate;
   }

   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Room getRoom() {
      return room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
}