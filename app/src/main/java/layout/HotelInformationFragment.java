package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.adapter.AdapterRoom;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_hotel_information)
public class HotelInformationFragment extends Fragment {

    private Hotel hotel;

    @ViewById
    TextView tvDescription;

    @ViewById
    TextView tvPhone;

    @ViewById
    TextView tvAddress;

    @ViewById
    TextView tvWebsite;

    @AfterViews
    @UiThread
    void updateVeiw(){
        hotel = (Hotel) getArguments().getSerializable("hotel");

        tvDescription.setText(hotel.getDescription());
        tvPhone.setText(hotel.getPhone());
        tvAddress.setText(String.format("%s %s , %s",hotel.getAddress().getStreet(),hotel.getAddress().getNumber(),hotel.getAddress().getCity()));
        tvWebsite.setText(hotel.getWebsite());
    }

}
