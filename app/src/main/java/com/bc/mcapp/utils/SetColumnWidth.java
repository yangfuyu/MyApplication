package com.bc.mcapp.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by admins on 2016/10/18.
 */
public class SetColumnWidth {

    public static int getColumnWidth(Activity context){
        WindowManager manager = context.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int columnWidth = width/4;
        return columnWidth;
    }

}
