package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import java.util.ArrayList;

/**
 * Created by Jan Sulja on 4/19/2017.
 */

public class AdapterHotel extends ArrayAdapter<Hotel> {

    private static class ViewHolder {
        private TextView hotelNameView;
        private TextView hotelPlaceView;
        private TextView hotelRatingView;
        private TextView hotelReviewsView;
        private RatingBar hotelStarsView;
        private ImageView hotelImageView;

    }

    public AdapterHotel(Context context, int textViewResourceId, ArrayList<Hotel> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.hotel_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.hotelNameView = (TextView) convertView.findViewById(R.id.hotelName);
            viewHolder.hotelPlaceView = (TextView) convertView.findViewById(R.id.hotelPlace);
            viewHolder.hotelRatingView = (TextView) convertView.findViewById(R.id.hotelRating);
            viewHolder.hotelReviewsView = (TextView) convertView.findViewById(R.id.hotelReviews);
            viewHolder.hotelStarsView = (RatingBar) convertView.findViewById(R.id.hotelStars);
            viewHolder.hotelImageView = (ImageView) convertView.findViewById(R.id.hotelImage);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Hotel hotel = getItem(position);
        if (hotel!= null) {
            viewHolder.hotelNameView.setText(hotel.getName());

            viewHolder.hotelPlaceView.setText(hotel.getAddress().getCity()
                    + ", " + hotel.getAddress().getCountry());

            viewHolder.hotelStarsView.setRating(hotel.getStars());

            viewHolder.hotelRatingView.setText(String.format("%1$,.2f /10",hotel.getRating()));

            String reviewText = hotel.getReviews().size() == 0
                    ? "No reviews": hotel.getReviews().size() + " reviews";
            viewHolder.hotelReviewsView.setText(reviewText);

            int imageResource = getContext().getResources()
                    .getIdentifier("@drawable/" + hotel.getImageFilename()
                            , "drawable", getContext().getPackageName());
            viewHolder.hotelImageView.setImageResource(imageResource);
        }

        return convertView;
    }
}
