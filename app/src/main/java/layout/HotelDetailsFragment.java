package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TabItem;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_hotel_details)
public class HotelDetailsFragment extends Fragment {

    private Hotel hotel;


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        hotel = (Hotel) getArguments().getSerializable("hotel");
//        View view = inflater.inflate(R.layout.fragment_hotel_details, container, false);
//
//        //initializeView(view);
//
//
//        return view;
//    }

    @AfterViews
    public void init(){
        hotel = (Hotel) getArguments().getSerializable("hotel");
        iniializeTabFragment();

    }



    public void iniializeTabFragment(){
        Fragment fragment;
        fragment = RoomListFragment_.builder().build();

        Bundle bundle = new Bundle();
        bundle.putSerializable("hotel",hotel);
        fragment.setArguments(bundle);

        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.tabFragment,fragment);
        ft.commit();
    }


    private void initializeView(View view) {

//        TextView tvHotelName = (TextView) view.findViewById(R.id.tvHotelName);
//        TextView tvHotelAddress = (TextView) view.findViewById(R.id.tvHotelAddress);
//        TextView tvHotelWebsite = (TextView) view.findViewById(R.id.tvHotelWebsite);
//        TextView tvHotelRating = (TextView) view.findViewById(R.id.tvHotelRating);
//        TextView tvHotelReviews = (TextView) view.findViewById(R.id.tvHotelReviews);
//        RatingBar rbHotelStars = (RatingBar) view.findViewById(R.id.rbHotelStars);
//
//        tvHotelName.setText(hotel.getName());
//        //tvHotelAddress.setText(hotel.getAddress());
//        tvHotelWebsite.setText(hotel.getWebsite());
//        tvHotelRating.setText(String.valueOf(hotel.getRating()) + " / 10");
//        //tvHotelReviews.setText(String.valueOf(hotel.getReviews()));
//        rbHotelStars.setRating(hotel.getStars());

    }
}
