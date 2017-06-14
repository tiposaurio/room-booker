package com.tim11.pma.ftn.pmaprojekat.service.internal;

import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomAmenityDAO;
import com.tim11.pma.ftn.pmaprojekat.model.RoomAmenity;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */
@EBean
public class RoomAmenityInternalService implements GenericInternalService<RoomAmenity> {

    @OrmLiteDao(helper = DatabaseHelper.class)
    RoomAmenityDAO roomAmenityDAO;

    @Override
    public List<RoomAmenity> getAll() {
        return null;
    }

    @Override
    public RoomAmenity create(RoomAmenity entity) {
        RoomAmenity roomAmenity = null;
        try {
            roomAmenity = roomAmenityDAO.queryBuilder().where().eq("amenityId",entity.getAmenityId()).and().eq("roomId",entity.getRoomId()).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(roomAmenity==null){
            roomAmenityDAO.create(entity);
        }

        return roomAmenity;
    }

    @Override
    public void createAll(List<RoomAmenity> list) {

    }

    @Override
    public RoomAmenity getById(int id) {
        return null;
    }

    public List<RoomAmenity> getByRoomId(int id){
        return roomAmenityDAO.getByRoomId(id);
    }
}
