package com.tim11.pma.ftn.pmaprojekat.service;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.HotelDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomDAO;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.internal.HotelInternalService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Jan Sulja on 6/15/2017.
 */
@EBean
public class SyncService {

    @Bean
    HotelInternalService hotelInternalService;

    @Bean
    HotelService hotelService;


    public void sync(){

        DatabaseHelper helper = OpenHelperManager.getHelper(getApplicationContext(),DatabaseHelper.class);
        helper.clearData();

        List<Hotel> externalHotelList = hotelService.get();
        hotelInternalService.createAll(externalHotelList);

    }

}
