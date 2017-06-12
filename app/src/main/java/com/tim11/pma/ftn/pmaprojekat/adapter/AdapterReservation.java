package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.dto.FbUserReviewDTO;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;
import com.tim11.pma.ftn.pmaprojekat.service.ReviewService;
import com.tim11.pma.ftn.pmaprojekat.service.ReviewService_;
import com.tim11.pma.ftn.pmaprojekat.widget.MyNumberPicker;

import org.springframework.web.client.RestClientException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jan Sulja on 5/21/2017.
 */
public class AdapterReservation extends ArrayAdapter<Reservation> {

    private ReviewService reviewService;

    private static class ViewHolder {
        private TextView tvName;
        private TextView tvAmenities;
        private TextView tvPrice;
        private TextView tvDescription;
        private TextView tvBeds;
        private TextView tvStartDate;
        private TextView tvEndDate;
        private CardView cvMakeReview;

    }
    public AdapterReservation(Context context, int textViewResourceId, ArrayList<Reservation> items) {
        super(context, textViewResourceId, items);
        reviewService = ReviewService_.getInstance_(getContext());
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
            viewHolder.cvMakeReview = (CardView) convertView.findViewById(R.id.cvMakeReview);

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

            // If the reservation is already reviewed or end date is not passed yet
            // hide the "Make Review" card view
            if (reservation.getReview() != null || reservation.getEndDate().after(new Date())) {
                viewHolder.cvMakeReview.setVisibility(View.GONE);
            } else {
                viewHolder.cvMakeReview.setVisibility(View.VISIBLE);
                viewHolder.cvMakeReview.setTag("cvMakeReview_" + reservation.getId());
                viewHolder.cvMakeReview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = getContext();
                        showDialog(context, reservation);
                    }
                });
            }
        }

        return convertView;
    }

    private void showDialog(Context context, final Reservation reservation) {

        LayoutInflater li = LayoutInflater.from(context);
        final View dialogView = li.inflate(R.layout.dialog_review, null);

        new AlertDialog.Builder(context)
                .setView(dialogView)
                .setPositiveButton("Review", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        final FbUserReviewDTO fbUserReviewDTO = new FbUserReviewDTO();
                        EditText etDesctiption =
                                (EditText) dialogView.findViewById(R.id.etDescription);
                        fbUserReviewDTO.setDescription(etDesctiption.getText().toString());
                        fbUserReviewDTO.setFbProfileId(Profile.getCurrentProfile().getId());
                        MyNumberPicker ratingNumberPicker =
                                (MyNumberPicker) dialogView.findViewById(R.id.mnpRating);
                        fbUserReviewDTO.setRating(ratingNumberPicker.getValue());
                        fbUserReviewDTO.setReservationId(reservation.getId());

                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                try {
                                    reviewService.create(fbUserReviewDTO);
                                }
                                catch (RestClientException e) {
                                    Log.e("REST ERROR", "Reviewing error");
                                }
                            }
                        }).start();

                        showToastMessage("Review complete", getContext(), Toast.LENGTH_LONG);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    private void showToastMessage(String text, Context context, int duration) {
        Toast toast = Toast.makeText(getContext(), text, duration);
        toast.show();
    }
}
