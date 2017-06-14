package com.bc.mcapp.biz;

import android.util.Log;

import com.bc.mcapp.biz.bizinterface.UserCartBiz;
import com.bc.mcapp.entity.order.Order_data;
import com.bc.mcapp.listener.OnUserCart;
import com.bc.mcapp.utils.GetRequestQueue;
import com.bc.mcapp.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.http.RequestParams;


/**
 * Created by admins on 2016/10/31.
 */
public class UserCartBIzImpl implements UserCartBiz {
    private OnUserCart onUserCart;
    private RequestQueue queue;

    public UserCartBIzImpl(OnUserCart onUserCart){
        this.onUserCart=onUserCart;
    }


    @Override
    public void getInsertUserCartBiz(String url) {
        queue= GetRequestQueue.getRequestQueue();
        Request<String> request= NoHttp.createStringRequest(url);
        queue.add(1,request,onResponseListener);
    }


    @Override
    public void getWaitPayOrder(String url) {
        queue=GetRequestQueue.getRequestQueue();
        Request<String> request=NoHttp.createStringRequest(url);
        queue.add(2,request,onResponseListener);

    }

    @Override
    public void getAddBuyCarTo(String url) {
        queue=GetRequestQueue.getRequestQueue();
        Request<String> request=NoHttp.createStringRequest(url);
        queue.add(3,request,onResponseListener);



    }


    private OnResponseListener<String> onResponseListener=new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            if(response != null){
                switch (what){
                    case 1:
                        try {
                            JSONObject jo=new JSONObject(response.get().toString());
                            JSONObject jo2=jo.getJSONObject("updateCart");
                            String js= jo2.getString("status");
                            if(js.equals("success")){
                                onUserCart.onInsertCart(true);
                            }else{
                                onUserCart.onInsertCart(false);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        Order_data data= JsonUtils.parse(response.get(),Order_data.class);
                        onUserCart.onWaitPayOrder(data);
                        break;
                    case 3:
                        try {
                            Log.i("qqq","www");
                            JSONObject   jo = new JSONObject(response.get().toString());
                            JSONObject jo2=jo.getJSONObject("addCart");
                            String js= jo2.getString("status");
                            if(js.equals("success")){
                                onUserCart.onAddBuyCarTo(true);
                            }else{
                                onUserCart.onAddBuyCarTo(false);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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
