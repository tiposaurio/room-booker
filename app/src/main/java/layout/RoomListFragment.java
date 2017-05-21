package layout;

import android.app.Fragment;
import android.widget.ListView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom_;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

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
