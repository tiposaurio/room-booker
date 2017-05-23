package com.tim11.pma.ftn.pmaprojekat.data.restapi;

import com.tim11.pma.ftn.pmaprojekat.converter.MyGsonHttpMessageConverter;
import com.tim11.pma.ftn.pmaprojekat.dto.FbUserReviewDTO;
import com.tim11.pma.ftn.pmaprojekat.model.Review;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/23/2017.
 */

@Rest(rootUrl = APIConstants.ROOT_URL, converters = {MyGsonHttpMessageConverter.class,
        FormHttpMessageConverter.class})
public interface ReviewAPI {

    @Post(value = APIConstants.REVIEW_PATH)
    Review createReview(@Body FbUserReviewDTO fbUserReviewDTO);

    @Get(value = APIConstants.REVIEW_PATH + "/fbprofile/{fbProfileId}")
    List<Review> getReviewsForFbProfile(@Path String fbProfileId);

    @Get(value = APIConstants.REVIEW_PATH + "/user/{userId}")
    List<Review> getReviewsForUser(@Path int userId);

    @Get(value = APIConstants.REVIEW_PATH + "/hotel/{hotelId}")
    List<Review> getReviewsForHotel(@Path int hotelId);
}
