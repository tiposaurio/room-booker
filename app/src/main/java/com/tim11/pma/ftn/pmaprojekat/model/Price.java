/***********************************************************************
 * Module:  Price.java
 * Author:  Shuky
 * Purpose: Defines the Class Price
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


/** @pdOid 08237c2c-b934-4630-a57a-996b6ba726b7 */
public class Price implements java.io.Serializable {
   /** @pdOid 61adcf9e-e8d3-435a-9d77-66816959497e */
   public int priceId;
   /** @pdOid c55f6393-0c82-44d8-a806-c3c74327cc0d */
   public java.util.Date startDate;
   /** @pdOid b910c9af-d4e4-4652-8d9f-57564a8dafb2 */
   public java.util.Date endDate;
   /** @pdOid f8460bd6-c615-4777-9144-9ad2caaf04c9 */
   public double value;
   
   /** @pdRoleInfo migr=no name=Room assc=relationship3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Room> room;
   
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
   public java.util.Collection<Room> getRoom() {
      if (room == null)
         room = new java.util.HashSet<Room>();
      return room;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorRoom() {
      if (room == null)
         room = new java.util.HashSet<Room>();
      return room.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRoom
    */
   public void setRoom(java.util.Collection<Room> newRoom) {
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
         this.room = new java.util.HashSet<Room>();
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
         for (java.util.Iterator iter = getIteratorRoom(); iter.hasNext();)
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
   public int getPriceId()
   {
      return priceId;
   }
   
   /**
    * Set value of priceId
    *
    * @param newPriceId 
    */
   public void setPriceId(int newPriceId)
   {
      this.priceId = newPriceId;
   }
   
   /**
    * Get value of startDate
    *
    * @return startDate 
    */
   public java.util.Date getStartDate()
   {
      return startDate;
   }
   
   /**
    * Set value of startDate
    *
    * @param newStartDate 
    */
   public void setStartDate(java.util.Date newStartDate)
   {
      this.startDate = newStartDate;
   }
   
   /**
    * Get value of endDate
    *
    * @return endDate 
    */
   public java.util.Date getEndDate()
   {
      return endDate;
   }
   
   /**
    * Set value of endDate
    *
    * @param newEndDate 
    */
   public void setEndDate(java.util.Date newEndDate)
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
      hashCode = 29 * hashCode + (new Integer(priceId)).hashCode();
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