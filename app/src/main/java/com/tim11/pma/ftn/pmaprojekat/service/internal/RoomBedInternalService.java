package com.tim11.pma.ftn.pmaprojekat.service.internal;

import com.tim11.pma.ftn.pmaprojekat.data.db.BedDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomBedDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomDAO;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.List;
import java.util.Set;

/**
 * Created by Jan Sulja on 6/14/2017.
 */
@EBean
public class RoomBedInternalService implements GenericInternalService<RoomBed> {

    @OrmLiteDao(helper = DatabaseHelper.class)
    RoomBedDAO roomBedDAO;

    @OrmLiteDao(helper = DatabaseHelper.class)
    BedDAO bedDAO;

    @Override
    public List<RoomBed> getAll() {
        return null;
    }

    @Override
    public RoomBed create(RoomBed entity) {
        return null;
    }

    @Override
    public void createAll(List<RoomBed> list) {


    }

    public void createAll(Set<RoomBed> set) {

        for (RoomBed rb :set) {

            bedDAO.createOrUpdate(rb.getBed());

        }
        roomBedDAO.createAll(set);
    }

    public void updateAll(Set<RoomBed> set) {

        for (RoomBed rb :set) {

            bedDAO.createOrUpdate(rb.getBed());

        }
        roomBedDAO.updateAll(set);
    }

    @Override
    public RoomBed getById(int id) {
        return null;
    }

    public Set<RoomBed> getRoomBedsByRoomId(int id) {

        return roomBedDAO.getByRoomId(id);

    }
}
