package com.bc.mcapp.presenter;

import com.bc.mcapp.biz.bizinterface.FgmHomeBiz;
import com.bc.mcapp.biz.FgmHomeBizImpl;
import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.entity.homepager.HomePager_data;
import com.bc.mcapp.listener.OnFgmHomeDataLis;
import com.bc.mcapp.presenter.preinterface.FgmHomePer;
import com.bc.mcapp.view.ViewFgm_FirstHome;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/16.
 */
public class FgmHomeImpl implements FgmHomePer, OnFgmHomeDataLis {
    private FgmHomeBiz fgmHomeBiz;
    private ViewFgm_FirstHome viewFgm_FirstHome;

    public FgmHomeImpl(){
        fgmHomeBiz=new FgmHomeBizImpl(this);
    }

    public void setViewFgm_FirstHome(ViewFgm_FirstHome viewFgm_FirstHome) {
        this.viewFgm_FirstHome = viewFgm_FirstHome;
    }


    @Override
    public void sendFgmHomeAllData(String url) {
        fgmHomeBiz.getFgmHomedataUrl(url);
    }

    @Override
    public void sendGridView(String url) {
        fgmHomeBiz.getGridViewUrl(url);
    }


    @Override
    public void onFgmHomeDataAll(HomePager_data data) {
        viewFgm_FirstHome.showFirstdata(data);
    }

    @Override
    public void onGridView(ArrayList<DataFirstObject> list) {
        viewFgm_FirstHome.showGridView(list);
    }


}
