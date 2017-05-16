/***********************************************************************
 * Module:  Reservation.java
 * Author:  Shuky
 * Purpose: Defines the Class Reservation
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;

 

/** @pdOid 4d3be5e2-2302-41f5-8665-3dfbf0e6870b */
public class Reservation implements java.io.Serializable {
   /** @pdOid 0b9dbee7-166f-4e41-8361-b2420ed4b778 */
   private long reservationId;
   /** @pdOid f61107a4-5089-476a-b1c0-66b29b073659 */
   private Date startDate;
   /** @pdOid 3f5530f2-940f-4d1c-a3be-12e12ef02a32 */
   private Date endDate;
   /** @pdOid c9582647-0aad-4ea4-b0ad-b8f926a75f62 */
   private double price;
   /** @pdOid 2ce7ece4-4e50-467d-8fe2-76192d308b58 */
   private String firstname;
   /** @pdOid df8e966c-ebdb-4101-b10c-55ebe87c15ce */
   private String lastname;
   /** @pdOid 6388a41a-ea3d-4810-b237-0788a93838f8 */
   private String email;
   
   /** @pdRoleInfo migr=no name=Room assc=relationship6 mult=1..1 side=A */
   private Room room;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Reservation() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default parent getter
    */
   
   public Room getRoom() {
      return room;
   }
   
   /**
    * @pdGenerated default parent setter
    * @param newRoom
    */
   public void setRoom(Room newRoom) {
      if (this.room == null || !this.room.equals(newRoom))
      {
         if (this.room != null)
         {
            Room oldRoom = this.room;
            this.room = null;
            //oldRoom.removeReservation(this);
         }
         if (newRoom != null)
         {
            this.room = newRoom;
            //this.room.addReservation(this);
         }
      }
   }
   
   /**
    * Get value of reservationId
    *
    * @return reservationId 
    */
   public long getReservationId()
   {
      return reservationId;
   }
   
   /**
    * Set value of reservationId
    *
    * @param newReservationId 
    */
   public void setReservationId(long newReservationId)
   {
      this.reservationId = newReservationId;
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
    * Get value of price
    *
    * @return price 
    */
   public double getPrice()
   {
      return price;
   }
   
   /**
    * Set value of price
    *
    * @param newPrice 
    */
   public void setPrice(double newPrice)
   {
      this.price = newPrice;
   }
   
   /**
    * Get value of firstname
    *
    * @return firstname 
    */
   public String getFirstname()
   {
      return firstname;
   }
   
   /**
    * Set value of firstname
    *
    * @param newFirstname 
    */
   public void setFirstname(String newFirstname)
   {
      this.firstname = newFirstname;
   }
   
   /**
    * Get value of lastname
    *
    * @return lastname 
    */
   public String getLastname()
   {
      return lastname;
   }
   
   /**
    * Set value of lastname
    *
    * @param newLastname 
    */
   public void setLastname(String newLastname)
   {
      this.lastname = newLastname;
   }
   
   /**
    * Get value of email
    *
    * @return email 
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * Set value of email
    *
    * @param newEmail 
    */
   public void setEmail(String newEmail)
   {
      this.email = newEmail;
   }


   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(reservationId)).hashCode();
      if (this.startDate != null) 
         hashCode = 29 * hashCode + startDate.hashCode();
      if (this.endDate != null) 
         hashCode = 29 * hashCode + endDate.hashCode();
      hashCode = 29 * hashCode + (new Double(price)).hashCode();
      if (this.firstname != null) 
         hashCode = 29 * hashCode + firstname.hashCode();
      if (this.lastname != null) 
         hashCode = 29 * hashCode + lastname.hashCode();
      if (this.email != null) 
         hashCode = 29 * hashCode + email.hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Reservation: " );
      ret.append( "reservationId='" + reservationId + "'");
      ret.append( "startDate='" + startDate + "'");
      ret.append( "endDate='" + endDate + "'");
      ret.append( "price='" + price + "'");
      ret.append( "firstname='" + firstname + "'");
      ret.append( "lastname='" + lastname + "'");
      ret.append( "email='" + email + "'");
      return ret.toString();
   }

}