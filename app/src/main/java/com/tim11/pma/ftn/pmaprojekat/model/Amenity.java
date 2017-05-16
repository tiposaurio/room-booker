/***********************************************************************
 * Module:  Amenity.java
 * Author:  Shuky
 * Purpose: Defines the Class Amenity
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

 

/** @pdOid 2c0fdfe1-cddd-4958-a539-f526eb9d66df */
public class Amenity implements java.io.Serializable {
   /** @pdOid 65fc18a7-f82a-4a1a-8e06-f7875f757987 */
   private long amenityId;
   /** @pdOid 41c21651-13fc-481e-b2f1-b7f3022ed9c1 */
   private String name;
   /** @pdOid 9f710edb-3275-4841-9cb1-2ab4ebf3c8c9 */
   private String description;
   /** @pdOid 524e0262-3811-426a-8e57-12e542077562 */
   private String icon;
   
   /** @pdRoleInfo migr=no name=Room assc=roomAmenity coll=java.util.Set impl=java.util.HashSet mult=0..* side=A */
   private java.util.Set<Room> RoomAmenity;
   /** @pdRoleInfo migr=no name=Hotel assc=relationship1 mult=1..1 side=A */
   private Hotel hotel;
   
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
    
   public java.util.Set<Room> getRoomAmenity() {
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
   public void setRoomAmenity(java.util.Set<Room> newRoomAmenity) {
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
   public long getAmenityId()
   {
      return amenityId;
   }
   
   /**
    * Set value of amenityId
    *
    * @param newAmenityId 
    */
   public void setAmenityId(long newAmenityId)
   {
      this.amenityId = newAmenityId;
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
   
   /**
    * Get value of icon
    *
    * @return icon 
    */
   public String getIcon()
   {
      return icon;
   }
   
   /**
    * Set value of icon
    *
    * @param newIcon 
    */
   public void setIcon(String newIcon)
   {
      this.icon = newIcon;
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
   
      if (this.icon == null ? cast.getIcon() != this.icon : !this.icon.equals( cast.getIcon()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(amenityId)).hashCode();
      if (this.name != null) 
         hashCode = 29 * hashCode + name.hashCode();
      if (this.description != null) 
         hashCode = 29 * hashCode + description.hashCode();
      if (this.icon != null) 
         hashCode = 29 * hashCode + icon.hashCode();
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
      ret.append( "icon='" + icon + "'");
      return ret.toString();
   }

}