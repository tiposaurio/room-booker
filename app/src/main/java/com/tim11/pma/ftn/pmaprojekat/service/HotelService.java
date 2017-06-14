package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.restapi.HotelAPI;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.internal.HotelInternalModel;
import com.tim11.pma.ftn.pmaprojekat.model.internal.InternalModelConverter;
import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALOHA-PC on 28-Apr-17.
 */

@EBean
public class HotelService implements GenericService<Hotel> {

    @RestService
    HotelAPI hotelAPI;

    //@OrmLiteDao(helper = DatabaseHelper.class)
    //HotelDAO hotelDAO;

    @Override
    public List<Hotel> get() {
        return hotelAPI.getHotels();
    }

    @Override
    public Hotel create(Hotel entity) {
        return hotelAPI.createHotel(entity);
    }

    @Override
    public Hotel getById(int id) {
        return hotelAPI.getHotel(id);
    }

//    public void saveFavouriteHotel(Hotel hotel){
//        hotelDAO.create(InternalModelConverter.convertToInternalModel(hotel));
//    }
//
//    public List<Hotel> getFavouriteHotels(){
//        List<HotelInternalModel> internalModels = hotelDAO.getFavoriteHotels();
//        List<Hotel> hotels = new ArrayList<>();
//        for(HotelInternalModel hotelInternalModel: internalModels){
//            hotels.add(InternalModelConverter.convertFromInternalModel(hotelInternalModel, this));
//        }
//        return hotels;
//    }

    public List<Hotel> search(SearchViewModel searchViewModel) {
        return hotelAPI.search(searchViewModel);
    }

}
