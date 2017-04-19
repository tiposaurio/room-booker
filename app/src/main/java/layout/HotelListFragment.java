package layout;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterHotel;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import java.util.ArrayList;


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


    }
}
