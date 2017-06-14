package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class RoomDAO extends RuntimeExceptionDao<Room,Integer> {

    public RoomDAO(Dao<Room, Integer> dao) {
        super(dao);
    }

    public List<Room> getRoomsByHotelId(int hotelId){
        List<Room> rooms = new ArrayList<>();
        try {
            rooms = this.queryBuilder().where().eq("hotel_id",hotelId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
