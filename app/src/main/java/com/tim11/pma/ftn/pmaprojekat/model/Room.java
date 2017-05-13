/***********************************************************************
 * Module:  Room.java
 * Author:  Shuky
 * Purpose: Defines the Class Room
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


/** @pdOid e9a0166c-0a76-4223-84db-1f61de312321 */
public class Room implements java.io.Serializable {
   /** @pdOid 39c52b24-65ef-4e06-a71d-c81e79fd0a3a */
   public int roomId;
   /** @pdOid a41c3e2a-5373-4d39-a7b2-9401a552109a */
   public java.lang.String name;
   
   /** @pdRoleInfo migr=no name=Amenity assc=relationship4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Amenity> RoomAmenity;
   /** @pdRoleInfo migr=no name=Reservation assc=relationship6 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Reservation> reservation;
   /** @pdRoleInfo migr=no name=Hotel assc=relationship2 mult=1..1 side=A */
   public Hotel hotel;
   /** @pdRoleInfo migr=no name=Price assc=relationship3 mult=1..1 side=A */
   public Price price;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Room() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
   public java.util.Collection<Amenity> getRoomAmenity() {
      if (RoomAmenity == null)
         RoomAmenity = new java.util.HashSet<Amenity>();
      return RoomAmenity;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorRoomAmenity() {
      if (RoomAmenity == null)
         RoomAmenity = new java.util.HashSet<Amenity>();
      return RoomAmenity.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRoomAmenity
    */
   public void setRoomAmenity(java.util.Collection<Amenity> newRoomAmenity) {
      //removeAllRoomAmenity();
      this.RoomAmenity = newRoomAmenity;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newAmenity
    */
   public void addRoomAmenity(Amenity newAmenity) {
      if (newAmenity == null)
         return;
      if (this.RoomAmenity == null)
         this.RoomAmenity = new java.util.HashSet<Amenity>();
      if (!this.RoomAmenity.contains(newAmenity))
      {
         this.RoomAmenity.add(newAmenity);
         newAmenity.addRoomAmenity(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldAmenity
    */
   public void removeRoomAmenity(Amenity oldAmenity) {
      if (oldAmenity == null)
         return;
      if (this.RoomAmenity != null)
         if (this.RoomAmenity.contains(oldAmenity))
         {
            this.RoomAmenity.remove(oldAmenity);
            oldAmenity.removeRoomAmenity(this);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllRoomAmenity() {
      if (RoomAmenity != null)
      {
         Amenity oldAmenity;
         for (java.util.Iterator iter = getIteratorRoomAmenity(); iter.hasNext();)
         {
            oldAmenity = (Amenity)iter.next();
            iter.remove();
            oldAmenity.removeRoomAmenity(this);
         }
      }
   }
   /**
    * @pdGenerated default getter
    */
   public java.util.Collection<Reservation> getReservation() {
      if (reservation == null)
         reservation = new java.util.HashSet<Reservation>();
      return reservation;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorReservation() {
      if (reservation == null)
         reservation = new java.util.HashSet<Reservation>();
      return reservation.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newReservation
    */
   public void setReservation(java.util.Collection<Reservation> newReservation) {
      //removeAllReservation();
      this.reservation = newReservation;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newReservation
    */
   public void addReservation(Reservation newReservation) {
      if (newReservation == null)
         return;
      if (this.reservation == null)
         this.reservation = new java.util.HashSet<Reservation>();
      if (!this.reservation.contains(newReservation))
      {
         this.reservation.add(newReservation);
         newReservation.setRoom(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldReservation
    */
   public void removeReservation(Reservation oldReservation) {
      if (oldReservation == null)
         return;
      if (this.reservation != null)
         if (this.reservation.contains(oldReservation))
         {
            this.reservation.remove(oldReservation);
            oldReservation.setRoom((Room)null);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllReservation() {
      if (reservation != null)
      {
         Reservation oldReservation;
         for (java.util.Iterator iter = getIteratorReservation(); iter.hasNext();)
         {
            oldReservation = (Reservation)iter.next();
            iter.remove();
            oldReservation.setRoom((Room)null);
         }
      }
   }
   /**
    * @pdGenerated default parent getter
    */
   public Hotel getHotel() {
      return hotel;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newHotel
    */
   public void setHotel(Hotel newHotel) {
      if (this.hotel == null || !this.hotel.equals(newHotel))
      {
         if (this.hotel != null)
         {
            Hotel oldHotel = this.hotel;
            this.hotel = null;
            //oldHotel.removeRoom(this);
         }
         if (newHotel != null)
         {
            this.hotel = newHotel;
            //this.hotel.addRoom(this);
         }
      }
   }
   /**
    * @pdGenerated default parent getter
    */
   public Price getPrice() {
      return price;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newPrice
    */
   public void setPrice(Price newPrice) {
      if (this.price == null || !this.price.equals(newPrice))
      {
         if (this.price != null)
         {
            Price oldPrice = this.price;
            this.price = null;
            //oldPrice.removeRoom(this);
         }
         if (newPrice != null)
         {
            this.price = newPrice;
            //this.price.addRoom(this);
         }
      }
   }
   
   /**
    * Get value of roomId
    *
    * @return roomId 
    */
   public int getRoomId()
   {
      return roomId;
   }
   
   /**
    * Set value of roomId
    *
    * @param newRoomId 
    */
   public void setRoomId(int newRoomId)
   {
      this.roomId = newRoomId;
   }
   
   /**
    * Get value of name
    *
    * @return name 
    */
   public java.lang.String getName()
   {
      return name;
   }
   
   /**
    * Set value of name
    *
    * @param newName 
    */
   public void setName(java.lang.String newName)
   {
      this.name = newName;
   }
   
  
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof Room))
         return false;
   
      Room cast = (Room) other;
   
      if (this.roomId != cast.getRoomId())
         return false;
   
      if (this.name == null ? cast.getName() != this.name : !this.name.equals( cast.getName()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Integer(roomId)).hashCode();
      if (this.name != null) 
         hashCode = 29 * hashCode + name.hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Room: " );
      ret.append( "roomId='" + roomId + "'");
      ret.append( "name='" + name + "'");
      return ret.toString();
   }

}