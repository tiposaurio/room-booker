package com.tim11.pma.ftn.pmaprojekat.util;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.tim11.pma.ftn.pmaprojekat.model.User;

/**
 * Created by ChogaraTheStrongest on 12-Jun-17.
 */

public class PreferenceUtil {

    public static User getLoggedUser(Context context) {
        Gson gson = new Gson();
        String loggedUserString = PreferenceManager
                .getDefaultSharedPreferences(context).getString("loggedUser", null);
        if (loggedUserString != null) {
            return gson.fromJson(loggedUserString, User.class);
        } else {
            return null;
        }
    }
}
