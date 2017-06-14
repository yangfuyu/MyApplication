package com.bc.mcapp.biz;

import android.util.Log;

import com.bc.mcapp.biz.bizinterface.UserBiz;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.listener.OnUSerInfo;
import com.bc.mcapp.utils.GetRequestQueue;
import com.bc.mcapp.utils.JsonUtils;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by admins on 2016/10/19.
 */
public class UserBizImpl implements UserBiz {
    private OnUSerInfo onUSerInfo;
    private RequestQueue queue;

    public UserBizImpl(OnUSerInfo onUSerInfo){
        this.onUSerInfo=onUSerInfo;
    }

    @Override
    public void getUserPhone(String phone) {
        RequestParams params=new RequestParams(phone);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                if(s!=null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String bool=jo.getString("status");
                        if(bool.equals("false")){
                            onUSerInfo.onUserLoginPhone(false);
                        }else{
                            onUSerInfo.onUserLoginPhone(true);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getAddUserInfo(String name, String pw) {
        RequestParams params=new RequestParams("loginId="+name+"&loginPwd="+pw);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(s != null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String js=jo.getString("status");
                        if(js.equals("true")){
                            onUSerInfo.onAddUserInfo(true);
                        }else {
                            onUSerInfo.onAddUserInfo(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getUserDengLu(String url) {
        RequestParams params=new RequestParams(url);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(s != null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String js=jo.getString("status");
                        if(js.equals("success")){
                            JSONObject jo1=jo.getJSONObject("user");
                            String jsr=jo1.getString("loginId");
                            onUSerInfo.onUserDengLu(true,jsr);
                        }else {
                            onUSerInfo.onUserDengLu(false,null);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getUserName(String newName) {
        RequestParams params=new RequestParams(newName);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String s) {
                if(s != null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String js=jo.getString("status");
                        if(js.equals("true")){
                            onUSerInfo.onUserUpdateName(true);
                        }else {
                            onUSerInfo.onUserUpdateName(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getUserPwd(String newPwd) {
        RequestParams params=new RequestParams(newPwd);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(s != null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String js=jo.getString("status");
                        if(js.equals("true")){
                            onUSerInfo.onUserUpdatePwd(true);
                        }else {
                            onUSerInfo.onUserUpdatePwd(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getUserSex(String newSex) {
        RequestParams params=new RequestParams(newSex);
        params.setMultipart(true);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                if(s!=null){
                    try {
                        JSONObject jo=new JSONObject(s);
                        String bool=jo.getString("true");
                        if(bool.equals("true")){
                            onUSerInfo.onUserUpdateSex(true);
                        }else{
                            onUSerInfo.onUserUpdateSex(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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
    public void getUserCar(String userId) {
        queue= GetRequestQueue.getRequestQueue();
        Request<String> request= NoHttp.createStringRequest(userId);
        queue.add(1,request,responseListener);

    }



    private OnResponseListener<String> responseListener=new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            if(response != null){
                switch (what){
                    case 1:
                        UserCar_data data=JsonUtils.parse(response.get(),UserCar_data.class);
                        onUSerInfo.onQueryUserCar(data);
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
