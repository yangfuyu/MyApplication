package com.bc.mcapp.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by admins on 2016/10/31.
 */
public class EncoderUtils {
    public static String convertCodeNetUTF(String code){
        String finName=null;
        if(code != null){
            try {
                String newName = new String(code.getBytes(),"utf-8");
                finName= URLEncoder.encode(newName,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return finName;
        }

        return null;
    }


}
