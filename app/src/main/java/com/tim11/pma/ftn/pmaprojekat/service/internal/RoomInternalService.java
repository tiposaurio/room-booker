package com.tim11.pma.ftn.pmaprojekat.service.internal;

import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.PriceDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomDAO;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Price;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.model.RoomAmenity;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.Collection;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */
@EBean
public class RoomInternalService implements GenericInternalService<Room> {

    @OrmLiteDao(helper = DatabaseHelper.class)
    RoomDAO roomDAO;

    @OrmLiteDao(helper = DatabaseHelper.class)
    PriceDAO priceDAO;

    @Bean
    AmenityInternalService amenityInternalService;

    @Bean
    RoomAmenityInternalService roomAmenityInternalService;

    @Bean
    RoomBedInternalService roomBedInternalService;

    @Override
    public List<Room> getAll() {

       List<Room> rooms = roomDAO.queryForAll();

        for (Room r : rooms) {
            r.setAmenities(amenityInternalService.getByRoomId(r.getId()));
        }
        return rooms;
    }



    @Override
    public Room create(Room entity) {
        return null;
    }

    @Override
    public void createAll(List<Room> list) {

        for (Room r : list) {

            for (Amenity a :r.getAmenities()) {

                amenityInternalService.createOrUpdate(a);
                RoomAmenity ra = new RoomAmenity();
                ra.setRoomId(r.getId());
                ra.setAmenityId(a.getId());
                roomAmenityInternalService.create(ra);
            }

            for(RoomBed rb :r.getRoomBeds()){
                rb.setRoom(r);
            }

            roomBedInternalService.createAll(r.getRoomBeds());
            priceDAO.create(r.getPrice());
            roomDAO.create(r);

        }


    }

    @Override
    public Room getById(int id) {
        return null;
    }


    public Collection<Room> getRoomsByHotelId(int id) {

        List<Room> rooms = roomDAO.queryForEq("hotel_id",id);

        for (Room r : rooms) {
            r.setAmenities(amenityInternalService.getByRoomId(r.getId()));
            r.setRoomBeds(roomBedInternalService.getRoomBedsByRoomId(r.getId()));
        }
        return rooms;
    }
}
