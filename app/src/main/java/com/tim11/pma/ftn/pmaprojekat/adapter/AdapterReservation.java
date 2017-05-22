package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Jan Sulja on 5/21/2017.
 */

public class AdapterReservation extends ArrayAdapter<Reservation> {

    private static class ViewHolder {
        private TextView tvName;
        private TextView tvAmenities;
        private TextView tvPrice;
        private TextView tvDescription;
        private TextView tvBeds;
        private TextView tvStartDate;
        private TextView tvEndDate;

    }
    public AdapterReservation(Context context, int textViewResourceId, ArrayList<Reservation> items) {
        super(context, textViewResourceId, items);
    }



    public View getView(int position, View convertView, ViewGroup parent) {

        AdapterReservation.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.reservation_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvAmenities = (TextView) convertView.findViewById(R.id.tvAmenities);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvBeds = (TextView) convertView.findViewById(R.id.tvBeds);
            viewHolder.tvStartDate = (TextView) convertView.findViewById(R.id.tvStartDate);
            viewHolder.tvEndDate = (TextView) convertView.findViewById(R.id.tvEndDate);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterReservation.ViewHolder) convertView.getTag();
        }

        final Reservation reservation = getItem(position);
        if (reservation!= null) {

            viewHolder.tvName.setText(reservation.getRoom().getName());
            viewHolder.tvPrice.setText(String.valueOf(reservation.getPrice()) + " €");
            viewHolder.tvDescription.setText(reservation.getRoom().getDescription());
            String amenities = "";
            for (Amenity a : reservation.getRoom().getAmenities()) {
                if(!amenities.isEmpty()){
                    amenities+="\n";
                }
                amenities += a.getName();

            }

            String beds = "";
            for (RoomBed b : reservation.getRoom().getRoomBeds()) {
                if(!beds.isEmpty()){
                    beds+="\n";
                }
                beds += b.getCount() + " x " + b.getBed().getName();
            }

            viewHolder.tvAmenities.setText(amenities);
            viewHolder.tvBeds.setText(beds);


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            viewHolder.tvStartDate.setText(sdf.format(reservation.getStartDate()));
            viewHolder.tvEndDate.setText(sdf.format(reservation.getEndDate()));


        }

        return convertView;
    }


}
