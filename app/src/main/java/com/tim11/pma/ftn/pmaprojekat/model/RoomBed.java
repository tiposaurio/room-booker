/***********************************************************************
 * Module:  RoomBed.java
 * Author:  Shuky
 * Purpose: Defines the Class RoomBed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public class RoomBed implements Serializable {
   @DatabaseField(id=true)
   private int id;
   @DatabaseField
   private int count;
   @DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate=true, foreignAutoRefresh=true, columnName = "room_id")
   private Room room;
   @DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate=true, foreignAutoRefresh=true)
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