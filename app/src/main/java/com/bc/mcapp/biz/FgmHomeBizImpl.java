package com.bc.mcapp.biz;

import android.util.Log;
import com.bc.mcapp.biz.bizinterface.FgmHomeBiz;
import com.bc.mcapp.entity.homepager.GetRenQiGoodsObject;
import com.bc.mcapp.entity.homepager.HomePager_data;
import com.bc.mcapp.listener.OnFgmHomeDataLis;
import com.bc.mcapp.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admins on 2016/10/16.
 */
public class FgmHomeBizImpl implements FgmHomeBiz {
    private OnFgmHomeDataLis onFgmHomeDataLis;

    public FgmHomeBizImpl(OnFgmHomeDataLis onFgmHomeDataLis){
            this.onFgmHomeDataLis=onFgmHomeDataLis;
    }


    @Override
    public void getFgmHomedataUrl(String url) {
        RequestParams params=new RequestParams(url);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                if (s != null) {
                    HomePager_data data= JsonUtils.parse(s,HomePager_data.class);
                    onFgmHomeDataLis.onFgmHomeDataAll(data);
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    @Override
    public void getGridViewUrl(String url) {
        RequestParams params=new RequestParams(url);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                if (s != null) {
                    GetRenQiGoodsObject da=JsonUtils.parse(s,GetRenQiGoodsObject.class);
                    Log.i("tts",da+"aa");
                    Log.i("tts",da.getData()+"aa");
                    onFgmHomeDataLis.onGridView(da.getData());
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
