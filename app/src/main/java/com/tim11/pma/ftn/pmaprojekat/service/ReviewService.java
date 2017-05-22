package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.data.restapi.ReviewAPI;
import com.tim11.pma.ftn.pmaprojekat.dto.FbUserReviewDTO;
import com.tim11.pma.ftn.pmaprojekat.model.Review;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/23/2017.
 */
@EBean
public class ReviewService implements GenericService<Review> {

    @RestService
    ReviewAPI reviewAPI;

    @Override
    public List<Review> get() {
        //TODO: Not implemented
        return null;
    }

    @Override
    public Review create(Review entity) {
        //TODO: Not implemented
        return null;
    }

    @Override
    public Review getById(int id) {
        //TODO: Not implemented
        return null;
    }

    public Review create(FbUserReviewDTO fbUserReviewDTO) {
        return reviewAPI.createReview(fbUserReviewDTO);
    }

    public List<Review> getReviewsForFbProfile(String fbProfileId){
        return reviewAPI.getReviewsForFbProfile(fbProfileId);
    }

    public List<Review> getReviewsForUser(int userId){
        return reviewAPI.getReviewsForUser(userId);
    }

    public List<Review> getReviewsForHotel(int hotelId){
        return reviewAPI.getReviewsForHotel(hotelId);
    }
}
