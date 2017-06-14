package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.common.CustomListView;
import com.bc.mcapp.common.alipaly.PayDemoActivity;
import com.bc.mcapp.entity.order.OrderListObject;
import com.bc.mcapp.entity.order.Order_data;
import com.bc.mcapp.presenter.UserCartPerImpl;
import com.bc.mcapp.ui.adapter.CtWaitPayOrderAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.IsIntentUtils;
import com.bc.mcapp.view.UserCart;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/11/2.
 */
@ContentView(R.layout.act_orderpay)
public class Act_OrderPay extends Activity implements UserCart {
    String uid;
    UserCartPerImpl userCartPerImpl;
    @ViewInject(R.id.DingDan_OrederNum)
    TextView DingDan_OrederNum;
    @ViewInject(R.id.DingDan_ReceverHumen)
    TextView DingDan_ReceverHumen;
    @ViewInject(R.id.DingDan_XiaDanTime)
    TextView DingDan_XiaDanTime;
    @ViewInject(R.id.DingDan_AllNum)
    TextView DingDan_AllNum;
    @ViewInject(R.id.DingDan_AllPrice)
    TextView DingDan_AllPrice;
    @ViewInject(R.id.DingDan_ListView)
    CustomListView ListView;
    ArrayList<OrderListObject> orderList;
    CtWaitPayOrderAdapter adapter;

    int AllNums;
    int AllPrice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uId");
        userCartPerImpl=new UserCartPerImpl();
        userCartPerImpl.setUserCart(this);
        if(uid != null){
            userCartPerImpl.sendWaitPayOrder(Constants.QUERY_NOPAY_ORDER+uid+"&orderType=0");
        }



    }

    @Event(value = {R.id.DingDan_Cancel,R.id.DingDan_Pay},type = View.OnClickListener.class)
    private void OnClick(View v){
            switch (v.getId()){
                case R.id.DingDan_Cancel:
                    Act_OrderPay.this.finish();
                break;
                case R.id.DingDan_Pay:
                    IsIntentUtils.toIntentActivity(Act_OrderPay.this, PayDemoActivity.class);
                    break;
            }
    }

    //////返回数据
    @Override
    public void showWaitPayOrder(Order_data data) {
        if(data != null){
            DingDan_OrederNum.setText(data.getData().get(0).getOid());
            DingDan_ReceverHumen.setText(uid);
            DingDan_XiaDanTime.setText("下单时间："+data.getData().get(0).getOtime());

            for (int i = 0; i <data.getData().get(0).getOrderList().size() ; i++) {
                AllNums+=Integer.parseInt(data.getData().get(0).getOrderList().get(i).getOnum());
            }
            DingDan_AllNum.setText("共"+AllNums+"件");
            DingDan_AllPrice.setText("￥"+data.getData().get(0).getTotalMoney());
            orderList=data.getData().get(0).getOrderList();
            adapter=new CtWaitPayOrderAdapter(Act_OrderPay.this,orderList);
            ListView.setAdapter(adapter);

        }
    }

    @Override
    public void showAddBuyCarTo(boolean bool) {

    }


    @Override
    public void showInsertCart(boolean bool) {

    }



}
