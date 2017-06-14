package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.RoomAmenity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class RoomAmenityDAO extends RuntimeExceptionDao<RoomAmenity, Integer> {
    public RoomAmenityDAO(Dao<RoomAmenity, Integer> dao) {
        super(dao);
    }

    public void save(RoomAmenity roomAmenity){
        this.create(roomAmenity);
    }

    public List<RoomAmenity> getByRoomId(int roomId){
        List<RoomAmenity> roomAmenities = null;
        try {
            roomAmenities = queryBuilder().where().eq("roomId",roomId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomAmenities;
    }

}
