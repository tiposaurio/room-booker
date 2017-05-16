package layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tim11.pma.ftn.pmaprojekat.DetailViewActivity;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterHotel;
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
import java.util.List;

import static android.R.attr.value;

@EFragment(R.layout.fragment_hotel_list)
public class HotelListFragment extends Fragment {



    private ArrayAdapter<Hotel> adapter;

    private ArrayList<Hotel> hotelList;

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
                    Hotel hotel = (Hotel) adapter.getItem(i);
                    Intent myIntent = new Intent(getActivity(), DetailViewActivity.class);
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
        try {
            hotelList = new ArrayList<>(hotelService.get());
            updateVeiw();


        } catch (RestClientException e) {
            System.out.println("ERROR" + e.toString());
        }
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.fragment_hotel_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        ListView lvHotels = (ListView) getView().findViewById(R.id.list);
//
//
//
//       // ArrayList<Hotel> list =  Hotel.getHotelsMock();
//
//        adapter=new AdapterHotel(getActivity(),R.layout.hotel_list_item,list);
//
//        lvHotels.setAdapter(adapter);
//
//        lvHotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Hotel hotel = (Hotel)adapter.getItem(i);
//                Intent myIntent = new Intent(getActivity(), DetailViewActivity.class);
//                myIntent.putExtra("hotel", hotel); //Optional parameters
//                //getActivity().startActivity(myIntent);
//                getActivity().startActivityForResult(myIntent,1);
//            }
//        });


    }


}
