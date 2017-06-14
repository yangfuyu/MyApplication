package com.bc.mcapp.biz.bizinterface;

/**
 * Created by admins on 2016/10/19.
 */
public interface UserBiz {
    void getUserPhone(String phone);
    void getAddUserInfo(String name,String pw);
    void getUserDengLu(String url);
    void getUserName(String newName);
    void getUserPwd(String newPwd);
    void getUserSex(String newSex);
    void getUserCar(String userId);



}
