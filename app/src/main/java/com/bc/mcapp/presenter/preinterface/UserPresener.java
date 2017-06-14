package com.bc.mcapp.presenter.preinterface;

/**
 * Created by admins on 2016/10/19.
 */
public interface UserPresener {
    void userCheckLogin(String url);
    void  userAddInfo(String name,String pw);
    void  userDengLu(String url);
    void userUpdateName(String newName);
    void userUpdatePwd(String newPwd);
    void userUpdateSex(String newSex);
    void userQueryUserCar(String userId);


}
