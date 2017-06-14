package com.bc.mcapp.listener;

import com.bc.mcapp.entity.usercar.UserCar_data;

/**
 * Created by admins on 2016/10/19.
 */
public interface OnUSerInfo {
    void onUserLoginPhone(boolean bool);
    void onAddUserInfo(boolean bool);
    void onUserDengLu(boolean bool,String str);
    void onUserUpdateName(boolean bool);
    void onUserUpdatePwd(boolean bool);
    void onUserUpdateSex(boolean bool);
    void onQueryUserCar(UserCar_data data);



}
