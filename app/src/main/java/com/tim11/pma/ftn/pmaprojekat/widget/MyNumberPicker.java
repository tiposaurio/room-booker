package com.tim11.pma.ftn.pmaprojekat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 *
 * link:
 *  https://stackoverflow.com/questions/12317960/android-numberpicker-set-min-max-default-from-xml
 */
public class MyNumberPicker extends NumberPicker {

    public MyNumberPicker(Context context) {
        super(context);
    }

    public MyNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        processAttributeSet(attrs);
    }

    public MyNumberPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        processAttributeSet(attrs);
    }

    private void processAttributeSet(AttributeSet attrs) {
        this.setMinValue(attrs.getAttributeIntValue(null, "min", 0));
        this.setMaxValue(attrs.getAttributeIntValue(null, "max", 0));
    }
}
