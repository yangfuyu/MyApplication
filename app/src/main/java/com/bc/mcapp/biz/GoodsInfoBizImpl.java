package com.bc.mcapp.biz;

import android.util.Log;
import com.bc.mcapp.biz.bizinterface.GoodsInfoBiz;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.detailgoods.GoodsInfo;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.listener.OnGoodsInfoLis;
import com.bc.mcapp.utils.GetRequestQueue;
import com.bc.mcapp.utils.JsonUtils;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

/**
 * Created by admins on 2016/10/20.
 */
public class GoodsInfoBizImpl implements GoodsInfoBiz {
    private OnGoodsInfoLis onGoodsInfoLis;
    RequestQueue queue;



    public GoodsInfoBizImpl(OnGoodsInfoLis onGoodsInfoLis){
        this.onGoodsInfoLis=onGoodsInfoLis;
    }


    @Override
    public void getFenLeiAllUrl(String url) {
        queue= GetRequestQueue.getRequestQueue();
        Request<String> request=NoHttp.createStringRequest(url);
        queue.add(1,request,responseListener);

    }


  /**
   * 模糊查询的方法
   * */
    @Override
    public void getLikeQueryGoods(String url) {
        queue=GetRequestQueue.getRequestQueue();
        Request<String> request=NoHttp.createStringRequest(url);
        queue.add(2,request,responseListener);
    }


    /**
     * 单个商品详情
     * */
    @Override
    public void getSingleGoodsInfo(String url) {
        queue=GetRequestQueue.getRequestQueue();
        Request<String> request=NoHttp.createStringRequest(url);
        queue.add(3,request,responseListener);
    }


    private  OnResponseListener<String> responseListener=new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {
        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            if(response != null){
                switch (what){
                    case 1:
                        Conditions_data data= JsonUtils.parse(response.get(),Conditions_data.class);
                        onGoodsInfoLis.onfenLeiToData(data);
                        break;

                    case 2:
                        LikeQueryGoods_Data data2=JsonUtils.parse(response.get(),LikeQueryGoods_Data.class);
                        onGoodsInfoLis.onLikeQueryGoods(data2);
                        break;
                    case 3:
                        DetailGoods_data data3=JsonUtils.parse(response.get(),DetailGoods_data.class);

                        onGoodsInfoLis.onSingleGoodsInfo(data3);
                        break;
                }
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
        }

        @Override
        public void onFinish(int what) {
        }
    };

}
