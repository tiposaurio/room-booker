/***********************************************************************
 * Module:  Price.java
 * Author:  Shuky
 * Purpose: Defines the Class Price
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Price implements Serializable {

   private int id;

   private Date startDate;

   private Date endDate;

   private double value;

   private Set<Room> rooms;

   public Price() {}

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

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }

   public Set<Room> getRooms() {
      return rooms;
   }

   public void setRooms(Set<Room> rooms) {
      this.rooms = rooms;
   }
}