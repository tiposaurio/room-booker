package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

import java.util.ArrayList;

/**
 * Created by Jan Sulja on 5/13/2017.
 */

public class AdapterRoom extends ArrayAdapter<Room> {

    private static class ViewHolder {
        private TextView tvName;
        private TextView tvAmenities;
        private TextView tvPrice;

    }

    public AdapterRoom(Context context, int textViewResourceId, ArrayList<Room> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        AdapterRoom.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.room_list_item, parent, false);

            viewHolder = new AdapterRoom.ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvAmenities = (TextView) convertView.findViewById(R.id.tvAmenities);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);




            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterRoom.ViewHolder) convertView.getTag();
        }

        Room item = getItem(position);
        if (item!= null) {

            viewHolder.tvName.setText(item.getName());
            viewHolder.tvPrice.setText(String.valueOf(item.getPrice().getValue()));
            String amenities = "";

            for (Amenity a : item.getRoomAmenity()) {
                amenities += a.getName() + "\n";
            }

            viewHolder.tvAmenities.setText(amenities);

        }

        return convertView;
    }
}
