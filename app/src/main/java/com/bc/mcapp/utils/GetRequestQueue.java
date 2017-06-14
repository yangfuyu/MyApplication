package com.bc.mcapp.utils;

import android.util.Log;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.RequestQueue;

/**
 * Created by admins on 2016/10/20.
 */
public class GetRequestQueue {
    private static GetRequestQueue getRequestQueue;
    private static RequestQueue queue;

    private  GetRequestQueue(){
        queue= NoHttp.newRequestQueue();

    }

    public static RequestQueue getRequestQueue(){
        if (getRequestQueue == null){
            getRequestQueue=new GetRequestQueue();
        }
        return queue;
    }


}
