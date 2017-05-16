/***********************************************************************
 * Module:  Address.java
 * Author:  Shuky
 * Purpose: Defines the Class Address
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;



/** @pdOid 9161d04f-b887-42e7-863a-1767a7df3fe4 */
public class Address implements java.io.Serializable {
   /** @pdOid 3be3c382-d667-454b-a140-d09a7480ef83 */
   public long addressId;
   /** @pdOid 4ea7241c-5c98-4889-9501-82f87ff2f4bd */
   public String street;
   /** @pdOid 073e510b-7773-4a4f-88f7-a6a17b9afe2c */
   public String number;
   /** @pdOid 8a9f15aa-9bc6-4f1e-a5ef-9e92628a20d7 */
   public String city;
   /** @pdOid 317766f4-de5b-4ff0-ba30-2c1f2ee27120 */
   public String country;
   /** @pdOid 13945da5-1f96-4971-84f3-0cab9133b625 */
   public double latitude;
   /** @pdOid 7a913a6a-a77e-4405-bc0a-42747c429982 */
   public double longitude;
   
   /** @pdRoleInfo migr=no name=Hotel assc=relationship5 coll=java.util.Set impl=java.util.HashSet mult=0..* */
   public Set<Hotel> hotel;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Address() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
    
   public Set<Hotel> getHotel() {
      if (hotel == null)
         hotel = new HashSet<Hotel>();
      return hotel;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
    
   public Iterator getIteratorHotel() {
      if (hotel == null)
         hotel = new HashSet<Hotel>();
      return hotel.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newHotel
    */
   public void setHotel(Set<Hotel> newHotel) {
      //removeAllHotel();
      this.hotel = newHotel;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newHotel
    */
   public void addHotel(Hotel newHotel) {
      if (newHotel == null)
         return;
      if (this.hotel == null)
         this.hotel = new HashSet<Hotel>();
      if (!this.hotel.contains(newHotel))
      {
         this.hotel.add(newHotel);
         newHotel.setAddress(this);
      }
   }
   
   /** 
    * @pdGenerated default remove
    * @param oldHotel
    */
   public void removeHotel(Hotel oldHotel) {
      if (oldHotel == null)
         return;
      if (this.hotel != null)
         if (this.hotel.contains(oldHotel))
         {
            this.hotel.remove(oldHotel);
            oldHotel.setAddress((Address)null);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllHotel() {
      if (hotel != null)
      {
         Hotel oldHotel;
         for (Iterator iter = getIteratorHotel(); iter.hasNext();)
         {
            oldHotel = (Hotel)iter.next();
            iter.remove();
            oldHotel.setAddress((Address)null);
         }
      }
   }
   
   /**
    * Get value of addressId
    *
    * @return addressId 
    */
   public long getAddressId()
   {
      return addressId;
   }
   
   /**
    * Set value of addressId
    *
    * @param newAddressId 
    */
   public void setAddressId(long newAddressId)
   {
      this.addressId = newAddressId;
   }
   
   /**
    * Get value of street
    *
    * @return street 
    */
   public String getStreet()
   {
      return street;
   }
   
   /**
    * Set value of street
    *
    * @param newStreet 
    */
   public void setStreet(String newStreet)
   {
      this.street = newStreet;
   }
   
   /**
    * Get value of number
    *
    * @return number 
    */
   public String getNumber()
   {
      return number;
   }
   
   /**
    * Set value of number
    *
    * @param newNumber 
    */
   public void setNumber(String newNumber)
   {
      this.number = newNumber;
   }
   
   /**
    * Get value of city
    *
    * @return city 
    */
   public String getCity()
   {
      return city;
   }
   
   /**
    * Set value of city
    *
    * @param newCity 
    */
   public void setCity(String newCity)
   {
      this.city = newCity;
   }
   
   /**
    * Get value of country
    *
    * @return country 
    */
   public String getCountry()
   {
      return country;
   }
   
   /**
    * Set value of country
    *
    * @param newCountry 
    */
   public void setCountry(String newCountry)
   {
      this.country = newCountry;
   }
   
   /**
    * Get value of latitude
    *
    * @return latitude 
    */
   public double getLatitude()
   {
      return latitude;
   }
   
   /**
    * Set value of latitude
    *
    * @param newLatitude 
    */
   public void setLatitude(double newLatitude)
   {
      this.latitude = newLatitude;
   }
   
   /**
    * Get value of longitude
    *
    * @return longitude 
    */
   public double getLongitude()
   {
      return longitude;
   }
   
   /**
    * Set value of longitude
    *
    * @param newLongitude 
    */
   public void setLongitude(double newLongitude)
   {
      this.longitude = newLongitude;
   }
   

   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof Address))
         return false;
   
      Address cast = (Address) other;
   
      if (this.addressId != cast.getAddressId())
         return false;
   
      if (this.street == null ? cast.getStreet() != this.street : !this.street.equals( cast.getStreet()))
         return false;
   
      if (this.number == null ? cast.getNumber() != this.number : !this.number.equals( cast.getNumber()))
         return false;
   
      if (this.city == null ? cast.getCity() != this.city : !this.city.equals( cast.getCity()))
         return false;
   
      if (this.country == null ? cast.getCountry() != this.country : !this.country.equals( cast.getCountry()))
         return false;
   
      if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(cast.getLatitude()))
               return false;
   
      if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(cast.getLongitude()))
               return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(addressId)).hashCode();
      if (this.street != null) 
         hashCode = 29 * hashCode + street.hashCode();
      if (this.number != null) 
         hashCode = 29 * hashCode + number.hashCode();
      if (this.city != null) 
         hashCode = 29 * hashCode + city.hashCode();
      if (this.country != null) 
         hashCode = 29 * hashCode + country.hashCode();
      hashCode = 29 * hashCode + (new Double(latitude)).hashCode();
      hashCode = 29 * hashCode + (new Double(longitude)).hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Address: " );
      ret.append( "addressId='" + addressId + "'");
      ret.append( "street='" + street + "'");
      ret.append( "number='" + number + "'");
      ret.append( "city='" + city + "'");
      ret.append( "country='" + country + "'");
      ret.append( "latitude='" + latitude + "'");
      ret.append( "longitude='" + longitude + "'");
      return ret.toString();
   }

}