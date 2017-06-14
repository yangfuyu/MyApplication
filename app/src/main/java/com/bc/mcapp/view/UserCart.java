package com.bc.mcapp.view;

import com.bc.mcapp.entity.order.Order_data;

/**
 * Created by admins on 2016/10/31.
 */
public interface UserCart {
    void showInsertCart(boolean bool);
    void showWaitPayOrder(Order_data data);
    void showAddBuyCarTo(boolean bool);
}
