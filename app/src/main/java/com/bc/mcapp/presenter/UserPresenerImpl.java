package com.bc.mcapp.presenter;

import android.util.Log;

import com.bc.mcapp.biz.UserBizImpl;
import com.bc.mcapp.biz.bizinterface.UserBiz;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.listener.OnUSerInfo;
import com.bc.mcapp.presenter.preinterface.UserPresener;
import com.bc.mcapp.view.UserShowLogin;

/**
 * Created by admins on 2016/10/19.
 */
public class UserPresenerImpl implements UserPresener,OnUSerInfo {
    private UserShowLogin userShowLogin;
    private UserBiz userBiz;

    public UserPresenerImpl(){
        userBiz=new UserBizImpl(this);
    }

    public void setUserShowLogin(UserShowLogin userShowLogin) {
        this.userShowLogin = userShowLogin;
    }

    @Override
    public void userCheckLogin(String url) {
        userBiz.getUserPhone(url);
    }

    @Override
    public void userAddInfo(String name, String pw) {
        userBiz.getAddUserInfo(name,pw);
    }

    @Override
    public void userDengLu(String url) {
        userBiz.getUserDengLu(url);
    }

    @Override
    public void userUpdateName(String newName) {
        userBiz.getUserName(newName);
    }

    @Override
    public void userUpdatePwd(String newPwd) {
        userBiz.getUserPwd(newPwd);
    }

    @Override
    public void userUpdateSex(String newSex) {
        userBiz.getUserSex(newSex);
    }

    @Override
    public void userQueryUserCar(String userId) {
        userBiz.getUserCar(userId);
    }


    @Override
    public void onUserLoginPhone(boolean bool) {
        userShowLogin.showUserLogin(bool);
    }

    @Override
    public void onAddUserInfo(boolean bool) {
        userShowLogin.showAddUser(bool);
    }

    @Override
    public void onUserDengLu(boolean bool,String name) {
        userShowLogin.showUserDenglu(bool,name);
    }

    @Override
    public void onUserUpdateName(boolean bool) {
        userShowLogin.showUpdateName(bool);
    }

    @Override
    public void onUserUpdatePwd(boolean bool) {
        userShowLogin.showUpdatePwd(bool);
    }

    @Override
    public void onUserUpdateSex(boolean bool) {
        userShowLogin.showUpdateSex(bool);
    }

    @Override
    public void onQueryUserCar(UserCar_data data) {
        userShowLogin.showQueryUserCar(data);
    }


}
