package com.tim11.pma.ftn.pmaprojekat.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.internal.HotelInternalModel;
import com.tim11.pma.ftn.pmaprojekat.model.internal.InternalModelConverter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavouritesDAO extends RuntimeExceptionDao<HotelInternalModel, Integer>{

    public FavouritesDAO(Dao<HotelInternalModel, Integer> dao) {
        super(dao);
    }

    //ima create metod a nmg nadjem neki getAll metod xD
    public List<HotelInternalModel> getFavoriteHotels() {

            return queryForAll();

    }

    public void addToFavourites(Hotel hotel){

        this.create(InternalModelConverter.convertToInternalModel(hotel));

    }

    public void removeFromFavourites(Hotel hotel)  {


        try {
            deleteBuilder().where().eq("actualId",hotel.getId());
            deleteBuilder().delete();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public HotelInternalModel getByActualId(int actualId) throws SQLException {
        return queryBuilder().where().eq("actualId",actualId).queryForFirst();
    }
}