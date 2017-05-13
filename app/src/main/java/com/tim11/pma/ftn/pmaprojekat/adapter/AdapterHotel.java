package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        private TextView itemView;
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
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.name);
            viewHolder.hotelRatingView = (TextView) convertView.findViewById(R.id.hotelRating);
            viewHolder.hotelReviewsView = (TextView) convertView.findViewById(R.id.hotelReviews);
            viewHolder.hotelStarsView = (RatingBar) convertView.findViewById(R.id.hotelStars);
            viewHolder.hotelImageView = (ImageView) convertView.findViewById(R.id.hotelImage);



            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Hotel item = getItem(position);
        if (item!= null) {
            // My layout has only one TextView
            // do whatever you want with your string and long
            //viewHolder.itemView.setText(String.format("%s %s", item.getName(), item.getAddress()));
            viewHolder.hotelRatingView.setText(String.format("%1$,.2f /10",item.getRating()));
            //viewHolder.hotelReviewsView.setText(String.format("%d reviews",item.getReviews()));
            viewHolder.hotelStarsView.setRating(item.getStars());
            viewHolder.hotelImageView.setImageResource(R.drawable.hotel1);
        }

        return convertView;
    }



}
