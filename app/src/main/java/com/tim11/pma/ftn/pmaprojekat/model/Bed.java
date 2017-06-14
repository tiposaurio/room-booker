/***********************************************************************
 * Module:  Bed.java
 * Author:  Shuky
 * Purpose: Defines the Class Bed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.Set;

public class Bed implements Serializable {
   @DatabaseField(generatedId = true,allowGeneratedIdInsert=true)
   private int id;
   @DatabaseField
   private String name;
   @DatabaseField
   private String icon;

   private Set<RoomBed> roomBeds;

   public Bed() {}

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

   public String getIcon() {
      return icon;
   }

   public void setIcon(String icon) {
      this.icon = icon;
   }

   public Set<RoomBed> getRoomBeds() {
      return roomBeds;
   }

   public void setRoomBeds(Set<RoomBed> roomBeds) {
      this.roomBeds = roomBeds;
   }
}