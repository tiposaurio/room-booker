/***********************************************************************
 * Module:  Room.java
 * Author:  Shuky
 * Purpose: Defines the Class Room
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.Iterator;
import java.util.Set;

/** @pdOid 6596f8df-cea7-426e-8367-f83dd990cd84 */
public class Room implements java.io.Serializable {
   /** @pdOid b70d6aae-2848-43b6-a3a4-7c407705e784 */
   private long roomId;
   /** @pdOid 3628ffc5-58b6-438a-9637-fd14ebaf2dc8 */
   private String name;
   /** @pdOid f40f84a6-0bd1-4cb4-9bad-6a26b5815396 */
   private int count;
   /** @pdOid ef63af54-b986-4d91-8cbb-a2d2d60cdc20 */
   private int available;
   /** @pdOid 44b1a927-1409-4937-9764-7b80479b9b85 */
   private String description;

   /** @pdRoleInfo migr=no name=Bed assc=roomBed coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<RoomBed> beds;
   /** @pdRoleInfo migr=no name=Amenity assc=roomAmenity coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<Amenity> roomAmenity;
   /** @pdRoleInfo migr=no name=Reservation assc=relationship6 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<Reservation> reservation;
   /** @pdRoleInfo migr=no name=Hotel assc=relationship2 mult=1..1 side=A */
   private Hotel hotel;
   /** @pdRoleInfo migr=no name=Price assc=relationship3 mult=1..1 side=A */
   private Price price;

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
   public Set<RoomBed> getBeds() {
      if (beds == null)
         beds = new java.util.HashSet<RoomBed>();
      return beds;
   }

   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorBeds() {
      if (beds == null)
         beds = new java.util.HashSet<RoomBed>();
      return beds.iterator();
   }

   /**
    * @pdGenerated default setter
    * @param newBeds
    */
   public void setBeds(Set<RoomBed> newBeds) {
      //removeAllBeds();
      this.beds = newBeds;
   }

   /**
    * @pdGenerated default add
    * @param newBed
    */
//   public void addBeds(RoomBed newBed) {
//      if (newBed == null)
//         return;
//      if (this.beds == null)
//         this.beds = new java.util.HashSet<RoomBed>();
//      if (!this.beds.contains(newBed))
//      {
//         this.beds.add(newBed);
//         newBed.addRooms(this);
//      }
//   }

   /**
    * @pdGenerated default remove
    * @param oldBed
    */
   public void removeBeds(Bed oldBed) {
      if (oldBed == null)
         return;
      if (this.beds != null)
         if (this.beds.contains(oldBed))
         {
            this.beds.remove(oldBed);
            oldBed.removeRooms(this);
         }
   }

   /**
    * @pdGenerated default removeAll
    */
   public void removeAllBeds() {
      if (beds != null)
      {
         Bed oldBed;
         for (java.util.Iterator iter = getIteratorBeds(); iter.hasNext();)
         {
            oldBed = (Bed)iter.next();
            iter.remove();
            oldBed.removeRooms(this);
         }
      }
   }
   /**
    * @pdGenerated default getter
    */
   public Set<Amenity> getRoomAmenity() {
      if (roomAmenity == null)
         roomAmenity = new java.util.HashSet<Amenity>();
      return roomAmenity;
   }

   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorRoomAmenity() {
      if (roomAmenity == null)
         roomAmenity = new java.util.HashSet<Amenity>();
      return roomAmenity.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRoomAmenity
    */
   public void setRoomAmenity(Set<Amenity> newRoomAmenity) {
      //removeAllRoomAmenity();
      this.roomAmenity = newRoomAmenity;
   }

   /**
    * @pdGenerated default add
    * @param newAmenity
    */
   public void addRoomAmenity(Amenity newAmenity) {
      if (newAmenity == null)
         return;
      if (this.roomAmenity == null)
         this.roomAmenity = new java.util.HashSet<Amenity>();
      if (!this.roomAmenity.contains(newAmenity))
      {
         this.roomAmenity.add(newAmenity);
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
      if (this.roomAmenity != null)
         if (this.roomAmenity.contains(oldAmenity))
         {
            this.roomAmenity.remove(oldAmenity);
            oldAmenity.removeRoomAmenity(this);
         }
   }

   /**
    * @pdGenerated default removeAll
    */
   public void removeAllRoomAmenity() {
      if (roomAmenity != null)
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
   public Set<Reservation> getReservation() {
      if (reservation == null)
         reservation = new java.util.HashSet<Reservation>();
      return reservation;
   }

   /**
    * @pdGenerated default iterator getter
    */
   public Iterator getIteratorReservation() {
      if (reservation == null)
         reservation = new java.util.HashSet<Reservation>();
      return reservation.iterator();
   }

   /**
    * @pdGenerated default setter
    * @param newReservation
    */
   public void setReservation(Set<Reservation> newReservation) {
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
   public long getRoomId()
   {
      return roomId;
   }
   
   /**
    * Set value of roomId
    *
    * @param newRoomId 
    */
   public void setRoomId(long newRoomId)
   {
      this.roomId = newRoomId;
   }
   
   /**
    * Get value of name
    *
    * @return name 
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * Set value of name
    *
    * @param newName 
    */
   public void setName(String newName)
   {
      this.name = newName;
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
   
   /**
    * Get value of available
    *
    * @return available 
    */
   public int getAvailable()
   {
      return available;
   }
   
   /**
    * Set value of available
    *
    * @param newAvailable 
    */
   public void setAvailable(int newAvailable)
   {
      this.available = newAvailable;
   }
   
   /**
    * Get value of description
    *
    * @return description 
    */
   public String getDescription()
   {
      return description;
   }
   
   /**
    * Set value of description
    *
    * @param newDescription 
    */
   public void setDescription(String newDescription)
   {
      this.description = newDescription;
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
   
      if (this.count != cast.getCount())
         return false;
   
      if (this.available != cast.getAvailable())
         return false;
   
      if (this.description == null ? cast.getDescription() != this.description : !this.description.equals( cast.getDescription()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(roomId)).hashCode();
      if (this.name != null)
         hashCode = 29 * hashCode + name.hashCode();
      hashCode = 29 * hashCode + (new Integer(count)).hashCode();
      hashCode = 29 * hashCode + (new Integer(available)).hashCode();
      if (this.description != null)
         hashCode = 29 * hashCode + description.hashCode();
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
      ret.append( "count='" + count + "'");
      ret.append( "available='" + available + "'");
      ret.append( "description='" + description + "'");
      return ret.toString();
   }

}