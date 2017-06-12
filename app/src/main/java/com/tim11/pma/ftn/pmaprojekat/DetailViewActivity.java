package com.tim11.pma.ftn.pmaprojekat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

import com.tim11.pma.ftn.pmaprojekat.listener.RefreshNameDrawerListener;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.util.PreferenceUtil;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import layout.HotelDetailsFragment_;

@EActivity
public class DetailViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static enum ActiveFragment { HOTEL_LIST, FILTER, SETTINGS, RESERVATIONS, LOGOUT}

    private Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        hotel = (Hotel) getIntent().getSerializableExtra("hotel");

        View headerLayout = navigationView.getHeaderView(0);
        ImageView profilePictureView = (ImageView)headerLayout.findViewById(R.id.navViewImageView);
        TextView nameTextView = (TextView) headerLayout.findViewById(R.id.navViewFullName);
        TextView emailTextView = (TextView) headerLayout.findViewById(R.id.navViewEmail);
        fillNavigationViewData(profilePictureView, nameTextView, emailTextView);

        initializeFragment();
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
        getMenuInflater().inflate(R.menu.detail_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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
            //changeFragment(new HotelListFragment());
            endActivity(Activity.RESULT_OK,ActiveFragment.HOTEL_LIST);

        } else if (id == R.id.nav_filter) {
            //changeFragment(new FilterFragment());
            endActivity(Activity.RESULT_OK,ActiveFragment.FILTER);
        }
        else if (id == R.id.nav_reservations) {
            endActivity(Activity.RESULT_OK, ActiveFragment.RESERVATIONS);
        }
        else if (id == R.id.nav_settings) {
            Intent myIntent = new Intent(this, SettingsViewActivity.class);
            this.startActivity(myIntent);
        }
        else if (id == R.id.logout) {
            endActivity(Activity.RESULT_OK,ActiveFragment.LOGOUT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void endActivity(int resultCode, ActiveFragment resultData) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",resultData);
        setResult(resultCode,returnIntent);
        finish();
    }

    void initializeFragment(){
        Fragment fragment;
        Bundle args = new Bundle();
        args.putSerializable("hotel", hotel);

        fragment = HotelDetailsFragment_.builder().build();
        fragment.setArguments(args);
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }

    void changeFragment(Fragment fragment){

        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment,fragment);
        ft.commit();
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
