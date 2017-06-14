package com.tim11.pma.ftn.pmaprojekat.data.restapi;

import com.tim11.pma.ftn.pmaprojekat.converter.MyGsonHttpMessageConverter;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;

import java.util.List;

/**
 * Created by ALOHA-PC on 28-Apr-17.
 */

@Rest(rootUrl = APIConstants.ROOT_URL, converters = {MyGsonHttpMessageConverter.class,
        FormHttpMessageConverter.class})
public interface ReservationAPI {

    @Post(value = APIConstants.RESERVATION_PATH)
    Reservation createReservation(@Body Reservation reservation);

    @Get(value = APIConstants.RESERVATION_PATH + "/{fbProfileId}")
    List<Reservation> getReservationsForFbProfile(@Path String fbProfileId);

    @Get(value = APIConstants.RESERVATION_PATH + "/room/{roomId}")
    Room getRoomById(@Path int roomId);

    // ...

}
