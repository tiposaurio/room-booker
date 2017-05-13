package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;


public class HotelDetailsFragment extends Fragment {

    private Hotel hotel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        hotel = (Hotel) getArguments().getSerializable("hotel");
        View view = inflater.inflate(R.layout.fragment_hotel_details, container, false);

        initializeView(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }

    private void initializeView(View view) {

        TextView tvHotelName = (TextView) view.findViewById(R.id.tvHotelName);
        TextView tvHotelAddress = (TextView) view.findViewById(R.id.tvHotelAddress);
        TextView tvHotelWebsite = (TextView) view.findViewById(R.id.tvHotelWebsite);
        TextView tvHotelRating = (TextView) view.findViewById(R.id.tvHotelRating);
        TextView tvHotelReviews = (TextView) view.findViewById(R.id.tvHotelReviews);
        RatingBar rbHotelStars = (RatingBar) view.findViewById(R.id.rbHotelStars);

        tvHotelName.setText(hotel.getName());
        //tvHotelAddress.setText(hotel.getAddress());
        tvHotelWebsite.setText(hotel.getWebsite());
        tvHotelRating.setText(String.valueOf(hotel.getRating()) + " / 10");
        //tvHotelReviews.setText(String.valueOf(hotel.getReviews()));
        rbHotelStars.setRating(hotel.getStars());

    }
}
