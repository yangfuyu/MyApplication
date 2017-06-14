package com.bc.mcapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.bc.mcapp.ui.activity.LoginActivity;

/**
 * Created by admins on 2016/10/21.
 */
public class IsIntentUtils {

    /*
    * 检查是否已经登录,如果没登录，去登陆
    * */
    public boolean isCheckLogin(Context context,boolean bool){
        if(bool){
            Intent intent=new Intent(context,LoginActivity.class);
            context.startActivity(intent);
            return true;
        }
        return false;
    }


     /*
    *  跳向未知Activity
    * */

    public static void toIntentActivity(Context context, Class act){
        Intent intent=new Intent(context,act);
        context.startActivity(intent);
    }


}
