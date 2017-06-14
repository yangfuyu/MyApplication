package com.bc.mcapp.listener;

import com.bc.mcapp.entity.order.Order_data;

/**
 * Created by admins on 2016/10/31.
 */
public interface OnUserCart {

    void onInsertCart(boolean bool);
    void onWaitPayOrder(Order_data data);
    void onAddBuyCarTo(boolean bool);

}
