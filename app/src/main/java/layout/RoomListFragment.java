package layout;


import android.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tim11.pma.ftn.pmaprojekat.DetailViewActivity;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterHotel;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
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
        AdapterRoom adapter = new AdapterRoom(getActivity(),R.layout.room_list_item,new ArrayList<>(hotel.getRoom()));
        roomList.setAdapter(adapter);

        roomList.setNestedScrollingEnabled(true);
    }

//    @AfterViews
//    @Background
//    void getHotelList() {
//        try {
//            hotelList = new ArrayList<>(hotelService.get());
//            updateVeiw();
//
//        } catch (RestClientException e) {
//            System.out.println("ERROR" + e.toString());
//        }
//    }


}
