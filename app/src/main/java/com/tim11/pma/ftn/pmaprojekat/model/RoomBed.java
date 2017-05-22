/***********************************************************************
 * Module:  RoomBed.java
 * Author:  Shuky
 * Purpose: Defines the Class RoomBed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.io.Serializable;

public class RoomBed implements Serializable {

   private int id;

   private int count;

   private Room room;

   private Bed bed;

   public RoomBed() {}

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public Room getRoom() {
      return room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public Bed getBed() {
      return bed;
   }

   public void setBed(Bed bed) {
      this.bed = bed;
   }
}