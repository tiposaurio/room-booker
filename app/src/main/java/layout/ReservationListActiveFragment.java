package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterReservation;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Date;

@EFragment(R.layout.fragment_reservation_list_active)
public class ReservationListActiveFragment extends Fragment {

    private ArrayList<Reservation> reservations;

    private ArrayAdapter<Reservation> adapter;

    @ViewById
    ListView reservationActiveList;

    @AfterViews
    @Background
    void init(){
        reservations = (ArrayList<Reservation>) getArguments().getSerializable("reservations_active");
        updateView();
    }

    @UiThread
    void updateView(){
        reservationActiveList.setNestedScrollingEnabled(true);
        adapter = new AdapterReservation(getActivity(),R.layout.reservation_list_item,reservations);
        reservationActiveList.setAdapter(adapter);

    }

}
