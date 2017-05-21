package com.tim11.pma.ftn.pmaprojekat.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.tim11.pma.ftn.pmaprojekat.R;

/**
 * Created by Jan Sulja on 5/21/2017.
 */

public class FragmentUtil {

    public static void changeFragment(int fragmentId, Fragment newFragment, FragmentManager fragmentManager, Bundle bundle){

        if(bundle!=null){
            newFragment.setArguments(bundle);
        }

        android.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(fragmentId,newFragment);
        ft.commit();

    }


}
