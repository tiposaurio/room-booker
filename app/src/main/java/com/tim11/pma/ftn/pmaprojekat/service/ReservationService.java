package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.data.restapi.HotelAPI;
import com.tim11.pma.ftn.pmaprojekat.data.restapi.ReservationAPI;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

/**
 * Created by Jan Sulja on 5/16/2017.
 */
@EBean
public class ReservationService implements GenericService<Reservation> {

    @RestService
    ReservationAPI reservationAPI;

    @Override
    public List<Reservation> get() {
        return null;
    }

    @Override
    public Reservation create(Reservation entity) {

        Room originalRoom = reservationAPI.getRoomById(entity.getRoom().getId());
        entity.setRoom(originalRoom);
        return reservationAPI.createReservation(entity);

    }

    public List<Reservation> getReservationsForFbProfile(String fbProfileId){
        return reservationAPI.getReservationsForFbProfile(fbProfileId);
    }

    @Override
    public Reservation getById(int id) {
        return null;
    }
}
