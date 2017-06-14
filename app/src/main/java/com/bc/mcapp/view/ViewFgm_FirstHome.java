package com.bc.mcapp.view;

import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.entity.homepager.HomePager_data;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/15.
 */
public interface ViewFgm_FirstHome {

    void showFirstdata(HomePager_data data);
    void showGridView(ArrayList<DataFirstObject> list);


}
