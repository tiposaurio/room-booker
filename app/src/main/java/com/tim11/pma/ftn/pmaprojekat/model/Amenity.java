/***********************************************************************
 * Module:  Amenity.java
 * Author:  Shuky
 * Purpose: Defines the Class Amenity
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


/** @pdOid 63ff51e7-3c6c-4f7f-b37d-94fa3d1c526e */
public class Amenity implements java.io.Serializable {
   /** @pdOid 73e7ae41-fd13-4c4c-9040-11f3c57567c0 */
   public int amenityId;
   /** @pdOid 1f3f5482-3e26-434a-b917-d982c6f7e25f */
   public java.lang.String name;
   /** @pdOid 6e0ac119-efae-4899-bf73-c8322b2a76e9 */
   public java.lang.String description;
   
   /** @pdRoleInfo migr=no name=Room assc=relationship4 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */

   public java.util.Collection<Room> RoomAmenity;
   /** @pdRoleInfo migr=no name=Hotel assc=relationship1 mult=1..1 side=A */
   public Hotel hotel;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Amenity() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */

   public java.util.Collection<Room> getRoomAmenity() {
      if (RoomAmenity == null)
         RoomAmenity = new java.util.HashSet<Room>();
      return RoomAmenity;
   }
   
   /**
    * @pdGenerated default iterator getter
    */

   public java.util.Iterator getIteratorRoomAmenity() {
      if (RoomAmenity == null)
         RoomAmenity = new java.util.HashSet<Room>();
      return RoomAmenity.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRoomAmenity
    */
   public void setRoomAmenity(java.util.Collection<Room> newRoomAmenity) {
      //removeAllRoomAmenity();
      this.RoomAmenity = newRoomAmenity;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newRoom
    */
   public void addRoomAmenity(Room newRoom) {
      if (newRoom == null)
         return;
      if (this.RoomAmenity == null)
         this.RoomAmenity = new java.util.HashSet<Room>();
      if (!this.RoomAmenity.contains(newRoom))
      {
         this.RoomAmenity.add(newRoom);
         newRoom.addRoomAmenity(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldRoom
    */
   public void removeRoomAmenity(Room oldRoom) {
      if (oldRoom == null)
         return;
      if (this.RoomAmenity != null)
         if (this.RoomAmenity.contains(oldRoom))
         {
            this.RoomAmenity.remove(oldRoom);
            oldRoom.removeRoomAmenity(this);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllRoomAmenity() {
      if (RoomAmenity != null)
      {
         Room oldRoom;
         for (java.util.Iterator iter = getIteratorRoomAmenity(); iter.hasNext();)
         {
            oldRoom = (Room)iter.next();
            iter.remove();
            oldRoom.removeRoomAmenity(this);
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
            //oldHotel.removeAmenity(this);
         }
         if (newHotel != null)
         {
            this.hotel = newHotel;
            //this.hotel.addAmenity(this);
         }
      }
   }
   
   /**
    * Get value of amenityId
    *
    * @return amenityId 
    */
   public int getAmenityId()
   {
      return amenityId;
   }
   
   /**
    * Set value of amenityId
    *
    * @param newAmenityId 
    */
   public void setAmenityId(int newAmenityId)
   {
      this.amenityId = newAmenityId;
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
   
   /**
    * Get value of description
    *
    * @return description 
    */
   public java.lang.String getDescription()
   {
      return description;
   }
   
   /**
    * Set value of description
    *
    * @param newDescription 
    */
   public void setDescription(java.lang.String newDescription)
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
   
      if (!(other instanceof Amenity))
         return false;
   
      Amenity cast = (Amenity) other;
   
      if (this.amenityId != cast.getAmenityId())
         return false;
   
      if (this.name == null ? cast.getName() != this.name : !this.name.equals( cast.getName()))
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
      hashCode = 29 * hashCode + (new Integer(amenityId)).hashCode();
      if (this.name != null) 
         hashCode = 29 * hashCode + name.hashCode();
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
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Amenity: " );
      ret.append( "amenityId='" + amenityId + "'");
      ret.append( "name='" + name + "'");
      ret.append( "description='" + description + "'");
      return ret.toString();
   }

}