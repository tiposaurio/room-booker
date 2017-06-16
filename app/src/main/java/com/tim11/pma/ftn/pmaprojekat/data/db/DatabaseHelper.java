package com.tim11.pma.ftn.pmaprojekat.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import com.tim11.pma.ftn.pmaprojekat.model.Address;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Bed;
import com.tim11.pma.ftn.pmaprojekat.model.FBUser;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Price;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Review;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.model.RoomAmenity;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.model.internal.HotelInternalModel;

import java.sql.SQLException;

/**
 * Created by ALOHA-PC on 13-May-17.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "pma.db";
    private static final int DATABASE_VERSION = 54; // TODO - when you change entities - change version

    private FavouritesDAO mFavouritesDao = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //CREATE TEBLES
            TableUtils.createTable(connectionSource, HotelInternalModel.class);
            TableUtils.createTable(connectionSource, Hotel.class);
            TableUtils.createTable(connectionSource, Address.class);
            TableUtils.createTable(connectionSource, Amenity.class);
            TableUtils.createTable(connectionSource, RoomAmenity.class);
            TableUtils.createTable(connectionSource, Bed.class);
            TableUtils.createTable(connectionSource, Price.class);
            TableUtils.createTable(connectionSource, Room.class);
            TableUtils.createTable(connectionSource, RoomBed.class);

            //...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //SAME
            TableUtils.dropTable(connectionSource, HotelInternalModel.class, true);
            TableUtils.dropTable(connectionSource, Hotel.class, true);
            TableUtils.dropTable(connectionSource, Address.class,true);
            TableUtils.dropTable(connectionSource, Amenity.class,true);
            TableUtils.dropTable(connectionSource, RoomAmenity.class,true);
            TableUtils.dropTable(connectionSource, Bed.class,true);
            TableUtils.dropTable(connectionSource, Price.class,true);
            TableUtils.dropTable(connectionSource, Room.class,true);
            TableUtils.dropTable(connectionSource, RoomBed.class,true);
            //...

            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearData(){
        ConnectionSource connectionSource = getConnectionSource();

        try {
            TableUtils.clearTable(getConnectionSource(), HotelInternalModel.class);
            TableUtils.clearTable(connectionSource, Hotel.class);
            TableUtils.clearTable(connectionSource, Address.class);
            TableUtils.clearTable(connectionSource, Amenity.class);
            TableUtils.clearTable(connectionSource, RoomAmenity.class);
            TableUtils.clearTable(connectionSource, Bed.class);
            TableUtils.clearTable(connectionSource, Price.class);
            TableUtils.clearTable(connectionSource, Room.class);
            TableUtils.clearTable(connectionSource, RoomBed.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
