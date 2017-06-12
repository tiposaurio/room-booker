package com.tim11.pma.ftn.pmaprojekat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tim11.pma.ftn.pmaprojekat.listener.RefreshNameDrawerListener;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.SpringTestModel;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.service.SpringTestModelService;
import com.tim11.pma.ftn.pmaprojekat.util.PreferenceUtil;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.springframework.web.client.RestClientException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import layout.FilterFragment_;
import layout.HotelListFragment;
import layout.HotelListFragment_;
import layout.HotelMapFragment_;
import layout.ReservationListFragment_;


@EActivity
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Fragment currentFragment;

    @Bean
    SpringTestModelService springTestModelService;

    @Bean
    HotelService hotelService;

    private ArrayList<Hotel> hotelList;

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        checkIfLoggedIn();

        FirebaseMessaging.getInstance().subscribeToTopic("main");

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addDrawerListener(new RefreshNameDrawerListener());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final View headerLayout = navigationView.getHeaderView(0);
        ImageView profilePictureView = (ImageView)headerLayout.findViewById(R.id.navViewImageView);
        TextView nameTextView = (TextView) headerLayout.findViewById(R.id.navViewFullName);
        TextView emailTextView = (TextView) headerLayout.findViewById(R.id.navViewEmail);
        fillNavigationViewData(profilePictureView, nameTextView, emailTextView);

        if(currentFragment==null){
            initializeFragment();
        }

    }

    @AfterViews
    @Background
    void restTest() {
        try {
            SpringTestModel s = springTestModelService.get().get(0);
            System.out.println("RESPONSE: "+s.getValue().getQuote());

//            ArrayList<Hotel> hotelList;
//            hotelList = new ArrayList<>(hotelService.get());
//            System.out.println("RESPONSE HOTEL: " + hotelList.get(0).getName());
//            hotelService.saveFavouriteHotel(hotelList.get(0));
//            System.out.println("FAVOURITE HOTELS SIZE: " + hotelService.getFavouriteHotels().size());

        } catch (RestClientException e) {
            System.out.println("ERORCINA");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_map) {

            changeFragment(HotelMapFragment_.builder().build());

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hotel_list) {
            changeFragment(HotelListFragment_.builder().build());

        } else if (id == R.id.nav_filter) {

            changeFragment(FilterFragment_.builder().build());

        } else if (id == R.id.nav_settings) {

            Intent myIntent = new Intent(this, SettingsViewActivity.class);
            this.startActivity(myIntent);
        } else if (id == R.id.nav_reservations) {

            changeFragment(ReservationListFragment_.builder().build());

        } else if (id == R.id.logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                DetailViewActivity_.ActiveFragment result =  (DetailViewActivity_.ActiveFragment) data.getSerializableExtra("result");
                switch (result){
                    case HOTEL_LIST: changeFragment(HotelListFragment_.builder().build()); break;
                    case FILTER: changeFragment(FilterFragment_.builder().build()); break;
                    case RESERVATIONS: changeFragment(ReservationListFragment_.builder().build()); break;
                    case LOGOUT: logout();
                    default: changeFragment(new HotelListFragment());
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    public void initMap(){
//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
//        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        }else{
            Toast.makeText(this,"Can't connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    void initializeFragment(){
        Fragment fragment;
        fragment = HotelListFragment_.builder().build();
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        currentFragment = fragment;
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }

    public void changeFragment(Fragment fragment){

        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        currentFragment = fragment;
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }


    public void checkIfLoggedIn(){
        if(AccessToken.getCurrentAccessToken()==null){
            goToWelcome();
        }
    }


    private void goToWelcome() {
        Intent intent = new Intent(this, WelcomeActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void logout(){
        LoginManager.getInstance().logOut();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .edit().remove("loggedUser").apply();
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir("images", Context.MODE_PRIVATE);
        File mypath = new File(directory,"profile.jpg");
        boolean deleted = mypath.delete();
        goToWelcome();
    }

    @Background
    @TargetApi(23)
    void fillNavigationViewData(final ImageView profilePictureView,
                                final TextView nameTextView,
                                final TextView emailTextView) {
        try {
            File profilePictureFile = new File(new ContextWrapper(getApplicationContext())
                    .getDir("images", Context.MODE_PRIVATE), "profile.jpg");
            final Bitmap b = BitmapFactory.decodeStream(new FileInputStream(profilePictureFile));

            final User loggedUser = PreferenceUtil.getLoggedUser(getApplicationContext());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    profilePictureView.setImageBitmap(b);
                    if (loggedUser != null) {
                        nameTextView.setText(loggedUser.getFirstname() + " " + loggedUser.getLastname());
                        emailTextView.setText(loggedUser.getEmail());
                    }
                }
            });
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find profile picture file in local directory!");
            e.printStackTrace();
        }
    }
}
