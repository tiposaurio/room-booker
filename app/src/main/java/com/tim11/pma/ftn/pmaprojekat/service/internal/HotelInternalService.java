package com.tim11.pma.ftn.pmaprojekat.service.internal;

import com.tim11.pma.ftn.pmaprojekat.data.db.AddressDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.HotelDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomDAO;
import com.tim11.pma.ftn.pmaprojekat.model.Address;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Sulja on 6/14/2017.
 */
@EBean
public class HotelInternalService implements GenericInternalService<Hotel>{

    @OrmLiteDao(helper = DatabaseHelper.class)
    HotelDAO hotelDAO;

    @OrmLiteDao(helper = DatabaseHelper.class)
    AddressDAO addressDAO;

    @Bean
    RoomInternalService roomInternalService;

    @Override
    public List<Hotel> getAll() {

        List<Hotel> hotelList = hotelDAO.getAll();

        for (Hotel h: hotelList) {
            h.setRooms(roomInternalService.getRoomsByHotelId(h.getId()));
        }

        return hotelList;
    }

    @Override
    public Hotel create(Hotel entity) {
        return null;
    }

    @Override
    public void createAll(List<Hotel> list) {

        for (Hotel h : list) {
            for (Room r : h.getRooms()) {
                r.setHotel(h);
            }
            roomInternalService.createAll(new ArrayList<Room>(h.getRooms()));
            //roomDAO.create(h.getRooms());
        }

        hotelDAO.saveAll(list);

    }

    public void updateAll(List<Hotel> list) {

        for (Hotel h : list) {
            for (Room r : h.getRooms()) {
                r.setHotel(h);
            }
            roomInternalService.updateAll(new ArrayList<Room>(h.getRooms()));

            addressDAO.createOrUpdate(h.getAddress());

            //roomDAO.create(h.getRooms());
        }



        hotelDAO.updateAll(list);

    }

    @Override
    public Hotel getById(int id) {
        Hotel h =  hotelDAO.queryForId(id);
        h.setRooms(roomInternalService.getRoomsByHotelId(id));
        return h;
    }
}
