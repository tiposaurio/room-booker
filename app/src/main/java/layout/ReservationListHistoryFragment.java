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
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_reservation_list_history)
public class ReservationListHistoryFragment extends Fragment {

    private ArrayList<Reservation> reservations;

    private ArrayAdapter<Reservation> adapter;

    @ViewById
    ListView reservationHistoryList;

    @AfterViews
    @Background
    void init(){
        reservations = (ArrayList<Reservation>) getArguments().getSerializable("reservations_history");
        updateView();
    }

    @UiThread
    void updateView(){
        reservationHistoryList.setNestedScrollingEnabled(true);
        adapter = new AdapterReservation(getActivity(),R.layout.reservation_list_item,reservations);
        reservationHistoryList.setAdapter(adapter);

    }


}
