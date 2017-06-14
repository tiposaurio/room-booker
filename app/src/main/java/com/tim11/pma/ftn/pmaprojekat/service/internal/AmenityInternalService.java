package com.tim11.pma.ftn.pmaprojekat.service.internal;

import com.tim11.pma.ftn.pmaprojekat.data.db.AmenityDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.RoomAmenity;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jan Sulja on 6/14/2017.
 */
@EBean
public class AmenityInternalService implements GenericInternalService<Amenity> {

    @OrmLiteDao(helper = DatabaseHelper.class)
    AmenityDAO amenityDAO;

    @Bean
    RoomAmenityInternalService roomAmenityInternalService;

    @Override
    public List<Amenity> getAll() {
        return null;
    }

    @Override
    public Amenity create(Amenity entity) {
        return null;
    }

    @Override
    public void createAll(List<Amenity> list) {

    }

    @Override
    public Amenity getById(int id) {
        return null;
    }

    public Set<Amenity> getByRoomId(int id){
        List<RoomAmenity> roomAmenities = roomAmenityInternalService.getByRoomId(id);
        Set<Amenity> amenities = new HashSet<>();

        for(RoomAmenity ra: roomAmenities){
            amenities.add(amenityDAO.queryForId(ra.getAmenityId()));
        }
        return amenities;

    }

    public void createOrUpdate(Amenity amenity){
        amenityDAO.createOrUpdate(amenity);
    }
}
