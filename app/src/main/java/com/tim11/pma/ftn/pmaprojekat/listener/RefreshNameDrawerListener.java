package com.tim11.pma.ftn.pmaprojekat.listener;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.util.PreferenceUtil;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ChogaraTheStrongest on 12-Jun-17.
 */
public class RefreshNameDrawerListener implements DrawerLayout.DrawerListener {

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        NavigationView navigationView = (NavigationView)drawerView.findViewById(R.id.nav_view);
        View headerLayout = navigationView.getHeaderView(0);
        //View headerLayout = LayoutInflater.from(drawerView.getContext().getApplicationContext()).inflate(R.layout.nav_header_main, navigationView, false);
        //navigationView.addHeaderView(headerLayout);
        TextView nameTextView = (TextView) headerLayout.findViewById(R.id.navViewFullName);
        TextView emailTextView = (TextView) headerLayout.findViewById(R.id.navViewEmail);
        User loggedUser = PreferenceUtil.getLoggedUser(drawerView.getContext().getApplicationContext());


        if (loggedUser != null) {
            nameTextView.setText(loggedUser.getFirstname() + " " + loggedUser.getLastname());
            emailTextView.setText(loggedUser.getEmail());
        }
    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
