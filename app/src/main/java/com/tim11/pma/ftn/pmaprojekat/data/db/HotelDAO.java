package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class HotelDAO extends RuntimeExceptionDao<Hotel, Integer>{



    public HotelDAO(Dao<Hotel, Integer> dao) {
        super(dao);
    }

    public List<Hotel> getAll(){

        return queryForAll();

    }

    public void saveAll(List<Hotel> hotelList){

//        for (Hotel h :hotelList) {
//
//            for(Room r : h.getRooms()){
//
//                roomDAO.create(r);
//
//            }
//        }
        this.create(hotelList);
    }

}
