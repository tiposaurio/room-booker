/***********************************************************************
 * Module:  RoomBed.java
 * Author:  Shuky
 * Purpose: Defines the Class RoomBed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;

/** @pdOid 2321ee32-db8b-46d2-8c7a-a8803f1fac0e */
public class RoomBed implements java.io.Serializable {
   /** @pdOid faf0ccbc-aaaa-4ecf-9375-003bb5773efe */
   private int count;
   
   private int roomBedId;
   private Room room;
   private Bed bed;
   
   
   
   
   public int getRoomBedId() {
	return roomBedId;
}

public void setRoomBedId(int roomBedId) {
	this.roomBedId = roomBedId;
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

/**
    * Empty constructor which is required by Hibernate
    *
    */
   public RoomBed() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * Get value of count
    *
    * @return count 
    */
   public int getCount()
   {
      return count;
   }
   
   /**
    * Set value of count
    *
    * @param newCount 
    */
   public void setCount(int newCount)
   {
      this.count = newCount;
   }
   

   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof RoomBed))
         return false;
   
      RoomBed cast = (RoomBed) other;
   
      if (this.count != cast.getCount())
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Integer(count)).hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.RoomBed: " );
      ret.append( "count='" + count + "'");
      return ret.toString();
   }

}