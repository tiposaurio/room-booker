/***********************************************************************
 * Module:  HotelDAO.java
 * Author:  Shuky
 * Purpose: Defines the Class HotelDAO
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;


/** @pdOid 4a965aa6-994a-451e-8783-43d5ae038f3b */
public class Reservation implements java.io.Serializable {
   /** @pdOid 158fbd63-2cd0-4f54-9b1d-f5d33329ee31 */
   public int reservationId;
   /** @pdOid 9b94f1a0-32f6-441f-95c1-9401b40b8016 */
   public java.util.Date startDate;
   /** @pdOid 1ca60688-acd5-497a-8869-9a4635cf698f */
   public java.util.Date endDate;
   /** @pdOid b64933c8-dc9c-47fe-adec-e1d631a9b57b */
   public double price;
   /** @pdOid 768d840e-2bbe-4d30-b16c-97171b46c81b */
   public java.lang.String firstname;
   /** @pdOid 096cf58a-9175-49e3-b13a-39032283358c */
   public java.lang.String lastname;
   
   /** @pdRoleInfo migr=no name=Room assc=relationship6 mult=1..1 side=A */
   public Room room;
   
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
   public int getReservationId()
   {
      return reservationId;
   }
   
   /**
    * Set value of reservationId
    *
    * @param newReservationId 
    */
   public void setReservationId(int newReservationId)
   {
      this.reservationId = newReservationId;
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
   public java.lang.String getFirstname()
   {
      return firstname;
   }
   
   /**
    * Set value of firstname
    *
    * @param newFirstname 
    */
   public void setFirstname(java.lang.String newFirstname)
   {
      this.firstname = newFirstname;
   }
   
   /**
    * Get value of lastname
    *
    * @return lastname 
    */
   public java.lang.String getLastname()
   {
      return lastname;
   }
   
   /**
    * Set value of lastname
    *
    * @param newLastname 
    */
   public void setLastname(java.lang.String newLastname)
   {
      this.lastname = newLastname;
   }
   
  
   
  
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Integer(reservationId)).hashCode();
      if (this.startDate != null) 
         hashCode = 29 * hashCode + startDate.hashCode();
      if (this.endDate != null) 
         hashCode = 29 * hashCode + endDate.hashCode();
      hashCode = 29 * hashCode + (new Double(price)).hashCode();
      if (this.firstname != null) 
         hashCode = 29 * hashCode + firstname.hashCode();
      if (this.lastname != null) 
         hashCode = 29 * hashCode + lastname.hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.HotelDAO: " );
      ret.append( "reservationId='" + reservationId + "'");
      ret.append( "startDate='" + startDate + "'");
      ret.append( "endDate='" + endDate + "'");
      ret.append( "price='" + price + "'");
      ret.append( "firstname='" + firstname + "'");
      ret.append( "lastname='" + lastname + "'");
      return ret.toString();
   }

}