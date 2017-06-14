package com.bc.mcapp.view;

import com.bc.mcapp.entity.usercar.UserCar_data;

/**
 * Created by admins on 2016/10/19.
 */
public interface UserShowLogin {
    void showUserLogin(boolean bool);
    void showAddUser(boolean boo);
    void showUserDenglu(boolean boo,String name);
    void showUpdateName(boolean bool);
    void showUpdatePwd(boolean bool);
    void showUpdateSex(boolean bool);
    void showQueryUserCar(UserCar_data data);



}
