/***********************************************************************
 * Module:  Hotel.java
 * Author:  Shuky
 * Purpose: Defines the Class Hotel
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


import com.j256.ormlite.field.DatabaseField;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel implements java.io.Serializable {
   /** @pdOid fdc32e8f-e8a2-46e6-ad8c-333dd79e5fe6 */
   @DatabaseField(generatedId = true)
   private int hotelId;
   /** @pdOid 9a284d7e-ff3e-4103-af37-5f2c97f47745 */
   @DatabaseField(canBeNull = false)
   private java.lang.String name;
   /** @pdOid 4a57ee5e-ce9e-4a0d-a75b-3093b0d9e5e4 */
   private java.lang.String description;
   /** @pdOid 7c5b614c-b514-4a6e-97c4-60562ad94564 */
   private java.lang.String website;
   /** @pdOid ee78e851-f309-4999-8592-0d5dc4b5889f */
   private java.lang.String phone;
   /** @pdOid 2a169de4-88f0-44ea-ad5f-c30f5c1f93dc */
   private int stars;
   /** @pdOid 8309f74e-6edc-4dd1-8203-54f189c77d07 */
   private double rating;
   
   /** @pdRoleInfo migr=no name=Amenity assc=relationship1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   private java.util.Collection<Amenity> amenity;
   /** @pdRoleInfo migr=no name=Room assc=relationship2 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   private java.util.Collection<Room> room;
   /** @pdRoleInfo migr=no name=Address assc=relationship5 mult=1..1 side=A */
  
   private Address address;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Hotel() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
   public java.util.Collection<Amenity> getAmenity() {
      if (amenity == null)
         amenity = new java.util.HashSet<Amenity>();
      return amenity;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorAmenity() {
      if (amenity == null)
         amenity = new java.util.HashSet<Amenity>();
      return amenity.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newAmenity
    */
   public void setAmenity(java.util.Collection<Amenity> newAmenity) {
      //removeAllAmenity();
      this.amenity = newAmenity;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newAmenity
    */
   public void addAmenity(Amenity newAmenity) {
      if (newAmenity == null)
         return;
      if (this.amenity == null)
         this.amenity = new java.util.HashSet<Amenity>();
      if (!this.amenity.contains(newAmenity))
      {
         this.amenity.add(newAmenity);
         newAmenity.setHotel(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldAmenity
    */
   public void removeAmenity(Amenity oldAmenity) {
      if (oldAmenity == null)
         return;
      if (this.amenity != null)
         if (this.amenity.contains(oldAmenity))
         {
            this.amenity.remove(oldAmenity);
            oldAmenity.setHotel((Hotel)null);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllAmenity() {
      if (amenity != null)
      {
         Amenity oldAmenity;
         for (java.util.Iterator iter = getIteratorAmenity(); iter.hasNext();)
         {
            oldAmenity = (Amenity)iter.next();
            iter.remove();
            oldAmenity.setHotel((Hotel)null);
         }
      }
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
         newRoom.setHotel(this);
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
            oldRoom.setHotel((Hotel)null);
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
            oldRoom.setHotel((Hotel)null);
         }
      }
   }
   /**
    * @pdGenerated default parent getter
    */
   public Address getAddress() {
      return address;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newAddress
    */
   public void setAddress(Address newAddress) {
      if (this.address == null || !this.address.equals(newAddress))
      {
         if (this.address != null)
         {
            Address oldAddress = this.address;
            this.address = null;
            //oldAddress.removeHotel(this);
         }
         if (newAddress != null)
         {
            this.address = newAddress;
            //this.address.addHotel(this);
         }
      }
   }
   
   /**
    * Get value of hotelId
    *
    * @return hotelId 
    */
   public int getHotelId()
   {
      return hotelId;
   }
   
   /**
    * Set value of hotelId
    *
    * @param newHotelId 
    */
   public void setHotelId(int newHotelId)
   {
      this.hotelId = newHotelId;
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
   
   /**
    * Get value of website
    *
    * @return website 
    */
   public java.lang.String getWebsite()
   {
      return website;
   }
   
   /**
    * Set value of website
    *
    * @param newWebsite 
    */
   public void setWebsite(java.lang.String newWebsite)
   {
      this.website = newWebsite;
   }
   
   /**
    * Get value of phone
    *
    * @return phone 
    */
   public java.lang.String getPhone()
   {
      return phone;
   }
   
   /**
    * Set value of phone
    *
    * @param newPhone 
    */
   public void setPhone(java.lang.String newPhone)
   {
      this.phone = newPhone;
   }
   
   /**
    * Get value of stars
    *
    * @return stars 
    */
   public int getStars()
   {
      return stars;
   }
   
   /**
    * Set value of stars
    *
    * @param newStars 
    */
   public void setStars(int newStars)
   {
      this.stars = newStars;
   }
   
   /**
    * Get value of rating
    *
    * @return rating 
    */
   public double getRating()
   {
      return rating;
   }
   
   /**
    * Set value of rating
    *
    * @param newRating 
    */
   public void setRating(double newRating)
   {
      this.rating = newRating;
   }
   
   
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof Hotel))
         return false;
   
      Hotel cast = (Hotel) other;
   
      if (this.hotelId != cast.getHotelId())
         return false;
   
      if (this.name == null ? cast.getName() != this.name : !this.name.equals( cast.getName()))
         return false;
   
      if (this.description == null ? cast.getDescription() != this.description : !this.description.equals( cast.getDescription()))
         return false;
   
      if (this.website == null ? cast.getWebsite() != this.website : !this.website.equals( cast.getWebsite()))
         return false;
   
      if (this.phone == null ? cast.getPhone() != this.phone : !this.phone.equals( cast.getPhone()))
         return false;
   
      if (this.stars != cast.getStars())
         return false;
   
      if (Double.doubleToLongBits(this.rating) != Double.doubleToLongBits(cast.getRating()))
               return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Integer(hotelId)).hashCode();
      if (this.name != null) 
         hashCode = 29 * hashCode + name.hashCode();
      if (this.description != null) 
         hashCode = 29 * hashCode + description.hashCode();
      if (this.website != null) 
         hashCode = 29 * hashCode + website.hashCode();
      if (this.phone != null) 
         hashCode = 29 * hashCode + phone.hashCode();
      hashCode = 29 * hashCode + (new Integer(stars)).hashCode();
      hashCode = 29 * hashCode + (new Double(rating)).hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Hotel: " );
      ret.append( "hotelId='" + hotelId + "'");
      ret.append( "name='" + name + "'");
      ret.append( "description='" + description + "'");
      ret.append( "website='" + website + "'");
      ret.append( "phone='" + phone + "'");
      ret.append( "stars='" + stars + "'");
      ret.append( "rating='" + rating + "'");
      return ret.toString();
   }

    public static ArrayList<Hotel> getHotelsMock() {
        Hotel h1 = new Hotel();
        h1.setName("asd");
        h1.setRating(5.6);
        h1.setStars(4);
        h1.setWebsite("www.asd.com");

        ArrayList<Hotel> list = new ArrayList<>();

        list.add(h1);
        list.add(h1);
        list.add(h1);

        return list;

    }
}