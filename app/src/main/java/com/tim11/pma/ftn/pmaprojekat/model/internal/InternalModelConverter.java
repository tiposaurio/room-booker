package com.tim11.pma.ftn.pmaprojekat.model.internal;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by ALOHA-PC on 13-May-17.
 */
@EBean
public class InternalModelConverter {

    @Bean
    HotelService hotelService;

    //other services
    //...

    public HotelInternalModel convertToInternalModel(Hotel hotel){
        HotelInternalModel internalModel =  new HotelInternalModel();
        internalModel.setActualId(hotel.getHotelId());
        return internalModel;
    }

    public Hotel convertFromInternalModel(HotelInternalModel internalModel){
        return hotelService.getById(internalModel.getActualId());
    }

    //add methods for conversion for other entities
    //...

}
