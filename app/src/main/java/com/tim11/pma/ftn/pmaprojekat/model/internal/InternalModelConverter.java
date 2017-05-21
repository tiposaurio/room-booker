package com.tim11.pma.ftn.pmaprojekat.model.internal;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by ALOHA-PC on 13-May-17.
 */
public class InternalModelConverter {


    //other services
    //...

    public static HotelInternalModel convertToInternalModel(Hotel hotel){
        HotelInternalModel internalModel =  new HotelInternalModel();
        internalModel.setActualId(hotel.getId());
        return internalModel;
    }

    public static Hotel convertFromInternalModel(HotelInternalModel internalModel, HotelService hotelService){
        return hotelService.getById(internalModel.getActualId());
    }

    //add methods for conversion for other entities
    //...

}
