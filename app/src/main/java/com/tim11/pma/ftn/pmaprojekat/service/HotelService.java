package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.data.restapi.HotelAPI;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

/**
 * Created by ALOHA-PC on 28-Apr-17.
 */

@EBean
public class HotelService implements GenericService<Hotel> {

    @RestService
    HotelAPI hotelAPI;

    @Override
    public List<Hotel> get() {
        return hotelAPI.getHotels();
    }

    @Override
    public Hotel create(Hotel entity) {
        return hotelAPI.createHotel(entity);
    }

}
