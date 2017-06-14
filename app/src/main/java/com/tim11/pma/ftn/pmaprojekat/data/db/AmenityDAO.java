package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class AmenityDAO extends RuntimeExceptionDao<Amenity, Integer> {

    public AmenityDAO(Dao<Amenity, Integer> dao) {
        super(dao);
    }

    public Set<Amenity> getByRoomId(int id) {
        Set<Amenity> amenities = null;

        try {
            amenities = new HashSet<Amenity>( queryBuilder().where().eq("room_id",id).query());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return amenities;
    }

    public void saveOrUpdate(Amenity amenity){
        this.createOrUpdate(amenity);
    }

}
