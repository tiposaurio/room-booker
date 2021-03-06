package layout;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_hotel_details)
public class HotelDetailsFragment extends Fragment {

    private Hotel hotel;

    @ViewById
    TabLayout tlDetails;

    @ViewById
    LinearLayout llScrollContent;

    @ViewById
    NestedScrollView nscTabLayout;

    @ViewById
    ImageView ivHotelImage;


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




        tlDetails.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getText().toString().toLowerCase()){

                    case "info": changeTabFragment(HotelInformationFragment_.builder().build()); break;
                    case "rooms": changeTabFragment(RoomListFragment_.builder().build()); break;
                    case "map": changeTabFragment(HotelLocationFragment_.builder().build()); break;



                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        hotel = (Hotel) getArguments().getSerializable("hotel");
        iniializeTabFragment();

        int imageResource = getResources().getIdentifier("@drawable/" + hotel.getImageFilename(), "drawable", getActivity().getPackageName());
        ivHotelImage.setImageResource(imageResource);

    }







    public void changeTabFragment(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putSerializable("hotel",hotel);
        fragment.setArguments(bundle);
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.tabFragment,fragment);
        ft.commit();
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
