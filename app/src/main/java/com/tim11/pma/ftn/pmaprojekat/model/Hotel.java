/***********************************************************************
 * Module:  Hotel.java
 * Author:  Shuky
 * Purpose: Defines the Class Hotel
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;

/** @pdOid 11b80e70-b677-460c-b503-d3bf2bf90081 */
public class Hotel implements java.io.Serializable {
   /** @pdOid b5a4b9d8-936f-42aa-b35c-1f18142c5acd */
   private int hotelId;
   /** @pdOid de88a6a3-b01c-4526-aba6-912a73143038 */
   private String name;
   /** @pdOid a14a157d-cc90-49a4-b118-e987a72a75f8 */
   private String description;
   /** @pdOid 4898072e-37c8-4e80-bca3-5a67cfcbbf3e */
   private String website;
   /** @pdOid 0540fe46-2e26-4984-ab66-bdf3dfd2dc5e */
   private String phone;
   /** @pdOid 63d00521-b444-4f22-b26e-7b2a1a5985cb */
   private int stars;
   /** @pdOid 09a62e4d-443a-4e25-aebd-cb6d13c13b8c */
   private double rating;
   /** @pdOid e8f7a53b-59c2-47d6-93d7-6c5421342c44 */
   private int reviews;
   /** @pdOid ef9265a4-34cb-48f7-9672-f61c80788dd9 */
   private String imageFilename;
   
   /** @pdRoleInfo migr=no name=Amenity assc=relationship1 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<Amenity> amenity;
   /** @pdRoleInfo migr=no name=Room assc=relationship2 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   private Set<Room> room;
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
   public Set<Amenity> getAmenity() {
      if (amenity == null)
         amenity = new HashSet<Amenity>();
      return amenity;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public Iterator getIteratorAmenity() {
      if (amenity == null)
         amenity = new HashSet<Amenity>();
      return amenity.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newAmenity
    */
   public void setAmenity(Set<Amenity> newAmenity) {
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
         this.amenity = new HashSet<Amenity>();
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
         for (Iterator iter = getIteratorAmenity(); iter.hasNext();)
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
         for (Iterator iter = getIteratorRoom(); iter.hasNext();)
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
    * Get value of website
    *
    * @return website 
    */
   public String getWebsite()
   {
      return website;
   }
   
   /**
    * Set value of website
    *
    * @param newWebsite 
    */
   public void setWebsite(String newWebsite)
   {
      this.website = newWebsite;
   }
   
   /**
    * Get value of phone
    *
    * @return phone 
    */
   public String getPhone()
   {
      return phone;
   }
   
   /**
    * Set value of phone
    *
    * @param newPhone 
    */
   public void setPhone(String newPhone)
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
   
   /**
    * Get value of reviews
    *
    * @return reviews 
    */
   public int getReviews()
   {
      return reviews;
   }
   
   /**
    * Set value of reviews
    *
    * @param newReviews 
    */
   public void setReviews(int newReviews)
   {
      this.reviews = newReviews;
   }
   
   /**
    * Get value of imageFilename
    *
    * @return imageFilename 
    */
   public String getImageFilename()
   {
      return imageFilename;
   }
   
   /**
    * Set value of imageFilename
    *
    * @param newImageFilename 
    */
   public void setImageFilename(String newImageFilename)
   {
      this.imageFilename = newImageFilename;
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
   
      if (this.reviews != cast.getReviews())
         return false;
   
      if (this.imageFilename == null ? cast.getImageFilename() != this.imageFilename : !this.imageFilename.equals( cast.getImageFilename()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(hotelId)).hashCode();
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
      hashCode = 29 * hashCode + (new Integer(reviews)).hashCode();
      if (this.imageFilename != null) 
         hashCode = 29 * hashCode + imageFilename.hashCode();
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
      ret.append( "reviews='" + reviews + "'");
      ret.append( "imageFilename='" + imageFilename + "'");
      return ret.toString();
   }

}