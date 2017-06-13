package com.tim11.pma.ftn.pmaprojekat.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.internal.HotelInternalModel;
import com.tim11.pma.ftn.pmaprojekat.model.internal.InternalModel;

import java.sql.SQLException;

/**
 * Created by ALOHA-PC on 13-May-17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "pma.db";
    private static final int DATABASE_VERSION = 2; // TODO - when you change entities - change version

    private HotelDAO mHotelDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //CREATE TEBLES
            TableUtils.createTable(connectionSource, HotelInternalModel.class);
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
            //...

            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HotelDAO getHotelDao() throws SQLException {
        if(mHotelDao==null){
            Dao<HotelInternalModel,Integer> dao = getDao(HotelInternalModel.class);
            mHotelDao = new HotelDAO(dao);
        }
        return mHotelDao;
    }
}
