package layout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService;
import com.tim11.pma.ftn.pmaprojekat.util.FragmentUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EFragment(R.layout.fragment_reservation_list)
public class ReservationListFragment extends Fragment {

    @Bean
    ReservationService reservationService;

    private List<Reservation> reservations;
    private List<Reservation> reservationsActive;
    private List<Reservation> reservationsHistory;

    @ViewById
    TabLayout tlReservations;


    @AfterViews
    public void init(){

        tlReservations.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Bundle bundle = new Bundle();

                switch (tab.getText().toString().toLowerCase()){

                    case "active":  bundle.putSerializable("reservations_active",new ArrayList<Reservation>(reservationsActive));
                                    FragmentUtil.changeFragment(R.id.tabReservationsFragment,ReservationListActiveFragment_.builder().build(),getFragmentManager(),bundle);
                                    break;

                    case "history":
                                    bundle.putSerializable("reservations_history",new ArrayList<Reservation>(reservationsHistory));
                                    FragmentUtil.changeFragment(R.id.tabReservationsFragment,ReservationListHistoryFragment_.builder().build(),getFragmentManager(),bundle);
                                    break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //TODO: Use logged user's ID and call reservation for logged ID
        getReservationsForFbProfile(Profile.getCurrentProfile().getId());
    }

    @Background
    public void getReservationsForFbProfile(String fbProfileId){
        reservations = reservationService.getReservationsForFbProfile(fbProfileId);
        splitReservations();
        Bundle bundle = new Bundle();
        bundle.putSerializable("reservations_active",new ArrayList<Reservation>(reservationsActive));
        FragmentUtil.changeFragment(R.id.tabReservationsFragment,ReservationListActiveFragment_.builder().build(),getFragmentManager(),bundle);
    }

    public void splitReservations(){

        if(reservationsActive==null){
            reservationsActive = new ArrayList<Reservation>();
        }

        if(reservationsHistory==null){
            reservationsHistory = new ArrayList<Reservation>();
        }

        for (Reservation r : reservations) {

            if(r.getEndDate().getTime() > new Date().getTime()){
                reservationsActive.add(r);
            }else{
                reservationsHistory.add(r);
            }
        }
    }
}
