package layout;

import android.content.Context;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_hotel_location)
public class HotelLocationFragment extends Fragment implements OnMapReadyCallback{

    GoogleMap mGoogleMap;


    private Hotel hotel;


    MapFragment mMapView;

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getActivity());
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setScrollGesturesEnabled(false);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);





        double lat = hotel.getAddress().getLatitude();
        double lng = hotel.getAddress().getLongitude();

        LatLng latLng = new LatLng(lat,lng);

        MarkerOptions mo = new MarkerOptions().position(latLng).title(hotel.getName());
        CameraPosition cp = CameraPosition.builder().target(latLng).zoom(16).bearing(0).tilt(45).build();



        mGoogleMap.addMarker(mo).showInfoWindow();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));





    }



    @AfterViews
    public void initMap(){

        hotel = (Hotel) getArguments().getSerializable("hotel");

        mMapView = (MapFragment) getChildFragmentManager().findFragmentById(R.id.mMapView);


        mMapView.getMapAsync(this);



    }
}
