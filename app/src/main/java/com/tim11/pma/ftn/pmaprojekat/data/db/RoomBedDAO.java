package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Price;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jan Sulja on 6/14/2017.
 */

public class RoomBedDAO extends RuntimeExceptionDao<RoomBed,Integer> {

    public RoomBedDAO(Dao<RoomBed, Integer> dao) {
        super(dao);
    }

    public void createAll(Set<RoomBed> roomBedSet){

        this.create(roomBedSet);

    }

    public void updateAll(Set<RoomBed> roomBedSet){

        for (RoomBed rb :roomBedSet) {
            this.createOrUpdate(rb);
        }



    }

    public Set<RoomBed> getByRoomId(int id) {
        return new HashSet<>(this.queryForEq("room_id",id));
    }
}
