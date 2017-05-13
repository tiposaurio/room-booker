package com.tim11.pma.ftn.pmaprojekat.data.db;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.internal.HotelInternalModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HotelDAO extends RuntimeExceptionDao<HotelInternalModel, Integer>{

    public HotelDAO(Dao<HotelInternalModel, Integer> dao) {
        super(dao);
    }

    //ima create metod a nmg nadjem neki getAll metod xD
    public List<HotelInternalModel> getFavoriteHotels() {
        try {
            return queryBuilder()
                    .query();
        } catch (SQLException e) {
            System.out.println("ERRORCINA");
        }
        return new ArrayList<>();
    }


}