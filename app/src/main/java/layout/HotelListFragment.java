package layout;

import android.content.Intent;
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

import java.util.ArrayList;

import static android.R.attr.value;


public class HotelListFragment extends Fragment {

    private ArrayAdapter<Hotel> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.fragment_hotel_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView lvHotels = (ListView) getView().findViewById(R.id.list);



        ArrayList<Hotel> list =  Hotel.getHotelsMock();
        adapter=new AdapterHotel(getActivity(),R.layout.hotel_list_item,list);

        lvHotels.setAdapter(adapter);

        lvHotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hotel hotel = (Hotel)adapter.getItem(i);
                Intent myIntent = new Intent(getActivity(), DetailViewActivity.class);
                myIntent.putExtra("hotel", hotel); //Optional parameters
                getActivity().startActivity(myIntent);
            }
        });


    }
}
