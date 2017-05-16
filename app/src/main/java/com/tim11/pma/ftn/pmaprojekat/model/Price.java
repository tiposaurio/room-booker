/***********************************************************************
 * Module:  Price.java
 * Author:  Shuky
 * Purpose: Defines the Class Price
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;

 

/** @pdOid 28b4b9ce-7300-404d-94ec-a0bbe67e8dec */
public class Price implements java.io.Serializable {
   /** @pdOid ddf3fd9f-7eb4-4c50-840a-22d0e2a8d754 */
   private long priceId;
   /** @pdOid 86c8ab67-d526-4deb-824f-e9b884a74536 */
   private Date startDate;
   /** @pdOid bf7b5169-9155-4691-9479-ee5c67ac1177 */
   private Date endDate;
   /** @pdOid 383be0f3-5214-4c81-83f0-b7811ad1eb74 */
   private double value;
   
   /** @pdRoleInfo migr=no name=Room assc=relationship3 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<Room> room;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Price() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
    
   public Set<Room> getRoom() {
      if (room == null)
         room = new HashSet<Room>();
      return room;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
    
   public Iterator getIteratorRoom() {
      if (room == null)
         room = new HashSet<Room>();
      return room.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRoom
    */
   public void setRoom(Set<Room> newRoom) {
      //removeAllRoom();
      this.room = newRoom;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newRoom
    */
   public void addRoom(Room newRoom) {
      if (newRoom == null)
         return;
      if (this.room == null)
         this.room = new HashSet<Room>();
      if (!this.room.contains(newRoom))
      {
         this.room.add(newRoom);
         newRoom.setPrice(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldRoom
    */
   public void removeRoom(Room oldRoom) {
      if (oldRoom == null)
         return;
      if (this.room != null)
         if (this.room.contains(oldRoom))
         {
            this.room.remove(oldRoom);
            oldRoom.setPrice((Price)null);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllRoom() {
      if (room != null)
      {
         Room oldRoom;
         for (Iterator iter = getIteratorRoom(); iter.hasNext();)
         {
            oldRoom = (Room)iter.next();
            iter.remove();
            oldRoom.setPrice((Price)null);
         }
      }
   }
   
   /**
    * Get value of priceId
    *
    * @return priceId 
    */
   public long getPriceId()
   {
      return priceId;
   }
   
   /**
    * Set value of priceId
    *
    * @param newPriceId 
    */
   public void setPriceId(long newPriceId)
   {
      this.priceId = newPriceId;
   }
   
   /**
    * Get value of startDate
    *
    * @return startDate 
    */
   public Date getStartDate()
   {
      return startDate;
   }
   
   /**
    * Set value of startDate
    *
    * @param newStartDate 
    */
   public void setStartDate(Date newStartDate)
   {
      this.startDate = newStartDate;
   }
   
   /**
    * Get value of endDate
    *
    * @return endDate 
    */
   public Date getEndDate()
   {
      return endDate;
   }
   
   /**
    * Set value of endDate
    *
    * @param newEndDate 
    */
   public void setEndDate(Date newEndDate)
   {
      this.endDate = newEndDate;
   }
   
   /**
    * Get value of value
    *
    * @return value 
    */
   public double getValue()
   {
      return value;
   }
   
   /**
    * Set value of value
    *
    * @param newValue 
    */
   public void setValue(double newValue)
   {
      this.value = newValue;
   }
   

   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(priceId)).hashCode();
      if (this.startDate != null) 
         hashCode = 29 * hashCode + startDate.hashCode();
      if (this.endDate != null) 
         hashCode = 29 * hashCode + endDate.hashCode();
      hashCode = 29 * hashCode + (new Double(value)).hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Price: " );
      ret.append( "priceId='" + priceId + "'");
      ret.append( "startDate='" + startDate + "'");
      ret.append( "endDate='" + endDate + "'");
      ret.append( "value='" + value + "'");
      return ret.toString();
   }

}