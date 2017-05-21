package com.tim11.pma.ftn.pmaprojekat.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Amenity;
import com.tim11.pma.ftn.pmaprojekat.model.Price;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.model.RoomBed;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService_;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jan Sulja on 5/13/2017.
 */
@EBean
public class AdapterRoom extends ArrayAdapter<Room> {

    private ReservationService reservationService;

    private static class ViewHolder {
        private TextView tvName;
        private TextView tvAmenities;
        private TextView tvPrice;
        private TextView tvDescription;
        private TextView tvBeds;
        private Button btnBook;
    }

    public AdapterRoom(Context context) {

        super(context, R.layout.room_list_item, new ArrayList<Room>());
        reservationService = ReservationService_.getInstance_(getContext());
    }

    public void init(ArrayList<Room> items){
        this.addAll(items);
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
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvBeds = (TextView) convertView.findViewById(R.id.tvBeds);
            viewHolder.btnBook = (Button) convertView.findViewById(R.id.btnBook);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterRoom.ViewHolder) convertView.getTag();
        }

        final Room item = getItem(position);
        if (item!= null) {

            viewHolder.tvName.setText(item.getName());
            viewHolder.tvPrice.setText(String.valueOf(item.getPrice().getValue()) + " €");
            viewHolder.tvDescription.setText(item.getDescription());
            String amenities = "";
            for (Amenity a : item.getRoomAmenity()) {
                if(!amenities.isEmpty()){
                    amenities+="\n";
                }
                amenities += a.getName();

            }

            String beds = "";
            for (RoomBed b : item.getBeds()) {
                if(!beds.isEmpty()){
                    beds+="\n";
                }
                beds += b.getCount() + " x " + b.getBed().getName();
            }

            viewHolder.tvAmenities.setText(amenities);
            viewHolder.tvBeds.setText(beds);

            viewHolder.btnBook.setTag("btnBook_" + item.getRoomId());
            viewHolder.btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getContext();
                    Reservation reservation = new Reservation();

                    setUserInfo(reservation);

                    reservation.setRoom(item);
                    showDialog(context,reservation,item.getPrice());

                }
            });

        }

        return convertView;
    }

    private void showDialog(Context context, final Reservation reservation, final Price price) {

        LayoutInflater li = LayoutInflater.from(context);
        final View dialogView = li.inflate(R.layout.dialog_booking, null);
        DatePicker dpStartDate = (DatePicker) dialogView.findViewById(R.id.dpStartDate);
        DatePicker dpEndDate = (DatePicker) dialogView.findViewById(R.id.dpEndDate);
        Calendar initTime = Calendar.getInstance();
        initTime.add(Calendar.DAY_OF_MONTH, 1);
        dpStartDate.init(initTime.get(Calendar.YEAR), initTime.get(Calendar.MONTH),
                initTime.get(Calendar.DAY_OF_MONTH), null);
        initTime.add(Calendar.DAY_OF_MONTH, 7);
        dpEndDate.init(initTime.get(Calendar.YEAR), initTime.get(Calendar.MONTH),
                initTime.get(Calendar.DAY_OF_MONTH), null);

        new AlertDialog.Builder(context)
                .setView(dialogView)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Date startTime = getDateFromDatePicker(dialogView,R.id.dpStartDate);
                        reservation.setStartDate(startTime);

                        Date endTime = getDateFromDatePicker(dialogView,R.id.dpEndDate);
                        reservation.setEndDate(endTime);

                        reservation.setPrice(calculatePrice(startTime,endTime, price));
                        book(reservation);

                        showToastMessage("Booking complete",getContext(),Toast.LENGTH_LONG);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
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


    private double calculatePrice(Date startDate, Date endDate, Price roomPrice){
        Long diffTime = endDate.getTime() - startDate.getTime();
        Long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return roomPrice.getValue()* diffDays.doubleValue();

    }

    private Date getDateFromDatePicker(View view,int datePickerId){

        DatePicker dpDate = (DatePicker) view.findViewById(datePickerId);
        int startDay = dpDate.getDayOfMonth();
        int startMonth = dpDate.getMonth()+1;
        int startYear = dpDate.getYear();

        Calendar calDate = Calendar.getInstance();
        calDate.set(startYear,startMonth,startDay);

        return calDate.getTime();

    }


    public void setUserInfo(final Reservation reservation){

        Profile profile = Profile.getCurrentProfile();
        reservation.setFirstname(profile.getFirstName());
        reservation.setLastname(profile.getLastName());

        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject user, GraphResponse graphResponse) {
                reservation.setEmail(user.optString("email"));

            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email");
        request.setParameters(parameters);
        request.executeAsync();


    }


    @Background
    public void book(Reservation reservation){

        try{
            reservationService.create(reservation);
        }catch(RestClientException e){

            Log.e("REST ERROR","Booking error");

        }

    }
}
