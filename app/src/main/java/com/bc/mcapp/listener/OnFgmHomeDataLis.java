package com.bc.mcapp.listener;

import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.entity.homepager.HomePager_data;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/16.
 */
public interface OnFgmHomeDataLis {

    void onFgmHomeDataAll(HomePager_data data);
    void onGridView(ArrayList<DataFirstObject> list);

}
