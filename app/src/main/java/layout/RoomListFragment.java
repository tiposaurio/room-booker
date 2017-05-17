package layout;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tim11.pma.ftn.pmaprojekat.DetailViewActivity;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterHotel;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom_;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;

import static com.tim11.pma.ftn.pmaprojekat.R.id.list;


@EFragment(R.layout.fragment_room_list)
public class RoomListFragment extends Fragment {

    private ArrayList<Hotel> hotelList;

    private Hotel hotel;

    @Bean
    HotelService hotelService;



    @ViewById
    ListView roomList;

    @AfterViews
    @UiThread
    void updateVeiw(){
        hotel = (Hotel) getArguments().getSerializable("hotel");
       // AdapterRoom adapter = new AdapterRoom(getActivity().getApplicationContext());
        AdapterRoom adapter = AdapterRoom_.getInstance_(getActivity());
        adapter.init(new ArrayList<Room>(hotel.getRoom()));
        roomList.setAdapter(adapter);
        roomList.setNestedScrollingEnabled(true);
    }







}
