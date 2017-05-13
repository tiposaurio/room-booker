/***********************************************************************
 * Module:  Address.java
 * Author:  Shuky
 * Purpose: Defines the Class Address
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;



/** @pdOid dff41944-645a-44e3-be15-044c312798db */
public class Address implements java.io.Serializable {
   /** @pdOid b6fe5dda-ae7c-448b-8f65-f5dbc76f77ee */
   private int addressId;
   /** @pdOid bef1788c-4f85-48b6-9a1d-abfa684f091c */
   private java.lang.String street;
   /** @pdOid eb3c2462-59b0-411b-b770-e4cdb2598b40 */
   private java.lang.String number;
   /** @pdOid 8d489398-e9c5-4dc3-b932-e0923515f809 */
   private java.lang.String city;
   /** @pdOid 455f0054-276e-486a-ba45-c0565b7b8af1 */
   private java.lang.String country;
   
   /** @pdRoleInfo migr=no name=Hotel assc=relationship5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<Hotel> hotel;
   
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
   public java.util.Collection<Hotel> getHotel() {
      if (hotel == null)
         hotel = new java.util.HashSet<Hotel>();
      return hotel;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   public java.util.Iterator getIteratorHotel() {
      if (hotel == null)
         hotel = new java.util.HashSet<Hotel>();
      return hotel.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newHotel
    */
   public void setHotel(java.util.Collection<Hotel> newHotel) {
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
         this.hotel = new java.util.HashSet<Hotel>();
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
         for (java.util.Iterator iter = getIteratorHotel(); iter.hasNext();)
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
   public int getAddressId()
   {
      return addressId;
   }
   
   /**
    * Set value of addressId
    *
    * @param newAddressId 
    */
   public void setAddressId(int newAddressId)
   {
      this.addressId = newAddressId;
   }
   
   /**
    * Get value of street
    *
    * @return street 
    */
   public java.lang.String getStreet()
   {
      return street;
   }
   
   /**
    * Set value of street
    *
    * @param newStreet 
    */
   public void setStreet(java.lang.String newStreet)
   {
      this.street = newStreet;
   }
   
   /**
    * Get value of number
    *
    * @return number 
    */
   public java.lang.String getNumber()
   {
      return number;
   }
   
   /**
    * Set value of number
    *
    * @param newNumber 
    */
   public void setNumber(java.lang.String newNumber)
   {
      this.number = newNumber;
   }
   
   /**
    * Get value of city
    *
    * @return city 
    */
   public java.lang.String getCity()
   {
      return city;
   }
   
   /**
    * Set value of city
    *
    * @param newCity 
    */
   public void setCity(java.lang.String newCity)
   {
      this.city = newCity;
   }
   
   /**
    * Get value of country
    *
    * @return country 
    */
   public java.lang.String getCountry()
   {
      return country;
   }
   
   /**
    * Set value of country
    *
    * @param newCountry 
    */
   public void setCountry(java.lang.String newCountry)
   {
      this.country = newCountry;
   }
   
   /**
    * Get value of addressPK.
    *
    * @return addressPK object
    */

   

 
   
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
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Integer(addressId)).hashCode();
      if (this.street != null) 
         hashCode = 29 * hashCode + street.hashCode();
      if (this.number != null) 
         hashCode = 29 * hashCode + number.hashCode();
      if (this.city != null) 
         hashCode = 29 * hashCode + city.hashCode();
      if (this.country != null) 
         hashCode = 29 * hashCode + country.hashCode();
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
      return ret.toString();
   }

}