package layout;

import android.content.Intent;
import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.tim11.pma.ftn.pmaprojekat.DetailViewActivity;
import com.tim11.pma.ftn.pmaprojekat.DetailViewActivity_;
import com.tim11.pma.ftn.pmaprojekat.MainActivity;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterHotel;
import com.tim11.pma.ftn.pmaprojekat.data.db.DatabaseHelper;
import com.tim11.pma.ftn.pmaprojekat.data.db.FavouritesDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.HotelDAO;
import com.tim11.pma.ftn.pmaprojekat.data.db.RoomDAO;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.service.internal.HotelInternalService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.ormlite.annotations.OrmLiteDao;
import org.springframework.web.client.RestClientException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EFragment(R.layout.fragment_hotel_list)
public class HotelListFragment extends Fragment {


    @OrmLiteDao(helper = DatabaseHelper.class)
    HotelDAO hotelDAO;

    @OrmLiteDao(helper = DatabaseHelper.class)
    RoomDAO roomDAO;

    @Bean
    HotelInternalService hotelInternalService;

    private ArrayAdapter<Hotel> adapter;

    private List<Hotel> hotelList;

    @ViewById
    ListView list;

    @Bean
    HotelService hotelService;

    @UiThread
    void updateVeiw(){

        if(getActivity()!=null) {
            adapter = new AdapterHotel(getActivity(), R.layout.hotel_list_item, hotelList);

            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Hotel hotel = adapter.getItem(i);
                    Intent myIntent = new Intent(getActivity(), DetailViewActivity_.class);
                    myIntent.putExtra("hotel", hotel); //Optional parameters
                    //getActivity().startActivity(myIntent);
                    getActivity().startActivityForResult(myIntent, 1);
                }
            });
        }
    }

    @AfterViews
    @Background
    void getHotelList() {

        MainActivity mainActivity =(MainActivity)getActivity();
        if(mainActivity.getHotelList() == null){


            List<Hotel> internalHotelList = null;
            internalHotelList = hotelInternalService.getAll();

            if(internalHotelList == null || internalHotelList.isEmpty()){
                try {
                    List<Hotel> externalHotelList = hotelService.get();
                    hotelList = new ArrayList<>(externalHotelList);

                    hotelInternalService.createAll(externalHotelList);
                } catch (RestClientException e) {
                    System.out.println("ERROR" + e.toString());
                    hotelList = new ArrayList<Hotel>();
                }
            }else{

                hotelList = new ArrayList<>(internalHotelList);


            }
        }else{
            hotelList = mainActivity.getHotelList();
        }
        updateVeiw();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//
//
//
//        return inflater.inflate(R.layout.fragment_hotel_list, container, false);
//    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
////        ListView lvHotels = (ListView) getView().findViewById(R.id.list);
////
////
////
////       // ArrayList<Hotel> list =  Hotel.getHotelsMock();
////
////        adapter=new AdapterHotel(getActivity(),R.layout.hotel_list_item,list);
////
////        lvHotels.setAdapter(adapter);
////
////        lvHotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Hotel hotel = (Hotel)adapter.getItem(i);
////                Intent myIntent = new Intent(getActivity(), DetailViewActivity.class);
////                myIntent.putExtra("hotel", hotel); //Optional parameters
////                //getActivity().startActivity(myIntent);
////                getActivity().startActivityForResult(myIntent,1);
////            }
////        });
//
//
//    }


}
