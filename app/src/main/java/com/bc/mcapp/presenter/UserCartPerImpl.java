package com.bc.mcapp.presenter;

import android.util.Log;

import com.bc.mcapp.biz.UserCartBIzImpl;
import com.bc.mcapp.biz.bizinterface.UserCartBiz;
import com.bc.mcapp.entity.order.Order_data;
import com.bc.mcapp.listener.OnUserCart;
import com.bc.mcapp.presenter.preinterface.UserCartPer;
import com.bc.mcapp.view.UserCart;

/**
 * Created by admins on 2016/10/31.
 */
public class UserCartPerImpl implements UserCartPer,OnUserCart {
    private UserCartBiz userCartBiz;
    private UserCart userCart;

    public void setUserCart(UserCart userCart) {
        this.userCart = userCart;
    }

    public UserCartPerImpl(){
        userCartBiz=new UserCartBIzImpl(this);
    }

    @Override
    public void sendInsertCartInfo(String url) {
        userCartBiz.getInsertUserCartBiz(url);
    }

    @Override
    public void sendWaitPayOrder(String url) {
        userCartBiz.getWaitPayOrder(url);
    }

    @Override
    public void sendAddBuyCarTo(String url) {
        userCartBiz.getAddBuyCarTo(url);
    }


    @Override
    public void onInsertCart(boolean bool) {
        userCart.showInsertCart(bool);
    }

    @Override
    public void onWaitPayOrder(Order_data data) {
        userCart.showWaitPayOrder(data);
    }

    @Override
    public void onAddBuyCarTo(boolean bool) {
        userCart.showAddBuyCarTo(bool);
    }
}
