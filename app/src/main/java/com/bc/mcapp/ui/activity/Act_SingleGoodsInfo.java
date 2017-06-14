package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.detailgoods.GoodsPicListObject;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.entity.order.Order_data;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.presenter.UserCartPerImpl;
import com.bc.mcapp.ui.adapter.GoodsSingleInfoVpAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.IsIntentUtils;
import com.bc.mcapp.view.GoodsInfo;
import com.bc.mcapp.view.UserCart;
import com.bumptech.glide.Glide;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/31.
 */
@ContentView(R.layout.home_goodsinfo_conein)
public class Act_SingleGoodsInfo extends Activity implements GoodsInfo ,View.OnClickListener,UserCart{
    @ViewInject(R.id.good_viewPager)
    ViewPager good_viewPager;
    @ViewInject(R.id.good_goodName)
    TextView good_goodName;
    @ViewInject(R.id.good_goodMoney)
    TextView good_goodMoney;
    @ViewInject(R.id.good_oldMoney)
    TextView good_oldMoney;
    @ViewInject(R.id.good_sellNum)
    TextView good_sellNum;
    @ViewInject(R.id.good_giveScore)
    TextView good_giveScore;
    @ViewInject(R.id.goods_tvNowBuy)
    TextView goods_tvNowBuy;
    GoodsInfoPreImpl goodsInfoPreImpl;
    GoodsSingleInfoVpAdapter adapter;
    String userName;
    boolean bo;
    IsIntentUtils IsCheck;
    PopupWindow pwindow;
    ImageView buypop_close,buypop_image;
    TextView buypop_jian,buypop_name,buypop_goodid,buypop_add,buypop_number;
    View  viewp;
    LinearLayout buypop_sure;
    boolean bool=false;
    DetailGoods_data QuanJuData;
    UserCartPerImpl userCartPerImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
        goodsInfoPreImpl=new GoodsInfoPreImpl();
        goodsInfoPreImpl.setGoodsInfo(this);
        userCartPerImpl=new UserCartPerImpl();
        userCartPerImpl.setUserCart(this);
        Intent intent=getIntent();
        String goodsId=intent.getStringExtra("goodsId");
        if(goodsId != null){
            goodsInfoPreImpl.singleGoodsInfo(Constants.GOODSINFO_URL+goodsId);
        }
        IsCheck=new IsIntentUtils();




        ////立即购买（添加到购物车）
        goods_tvNowBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bo){
                    popuwindow();


                }else{
                    Toast.makeText(Act_SingleGoodsInfo.this, "您还没有登录，请登录!", Toast.LENGTH_SHORT).show();

                            try {
                                Thread.sleep(1000);
                                IsCheck.isCheckLogin(Act_SingleGoodsInfo.this,true);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }



            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh=getSharedPreferences("LoginSuccess", Context.MODE_PRIVATE);
        userName=sh.getString("LoginSuccessName","noUser");
        bo=sh.getBoolean("LoginSuccessBool",false);
    }

    private void popuwindow(){

        viewp=View.inflate(Act_SingleGoodsInfo.this, R.layout.act_nowbuy_popud, null);
        pwindow = new PopupWindow(viewp, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        pwindow.setFocusable(true);
        pwindow.setBackgroundDrawable(new BitmapDrawable());
        pwindow.showAtLocation(viewp, Gravity.BOTTOM, 0, 0);

        buypop_close= (ImageView) viewp.findViewById(R.id.buypop_close);
        buypop_jian= (TextView) viewp.findViewById(R.id.buypop_jian);
        buypop_add= (TextView) viewp.findViewById(R.id.buypop_add);
        buypop_number=(TextView) viewp.findViewById(R.id.buypop_number);
        buypop_image= (ImageView) viewp.findViewById(R.id.buypop_image);
        buypop_name=(TextView) viewp.findViewById(R.id.buypop_name);
        buypop_goodid=(TextView) viewp.findViewById(R.id.buypop_goodid);
        buypop_sure= (LinearLayout) viewp.findViewById(R.id.buypop_sure);
        bool=true;
        if(bool && QuanJuData!=null){
            Glide.with(this).load(Constants.IMG_URL+QuanJuData.getGoodsInfo().getGoodsPicList().get(0).getIcon()).placeholder(R.mipmap.ic_launcher).into(buypop_image);
            buypop_name.setText(QuanJuData.getGoodsInfo().getGoodsName());
            buypop_goodid.setText(QuanJuData.getGoodsInfo().getGoodsId());
        }


        buypop_close.setOnClickListener(this);
        buypop_jian.setOnClickListener(this);
        buypop_add.setOnClickListener(this);
        buypop_sure.setOnClickListener(this);
    }


    @Override
    public void showSingleGoodsInfo(DetailGoods_data data) {
        if(data != null){
            QuanJuData=data;
            adapter=new GoodsSingleInfoVpAdapter(Act_SingleGoodsInfo.this,data.getGoodsInfo().getGoodsPicList());
            good_viewPager.setAdapter(adapter);
            good_goodName.setText(data.getGoodsInfo().getGoodsName());
            good_goodMoney.setText("现价："+data.getGoodsInfo().getNewPrice());
            good_oldMoney.setText("原价："+data.getGoodsInfo().getOldPrice());
            good_sellNum.setText("销量："+data.getGoodsInfo().getSellNum());
            good_giveScore.setText(data.getGoodsInfo().getCurrentNum());



        }
    }











    @Override
    public void showGoodsTypeData(Conditions_data data) {

    }

    @Override
    public void showLikeQueryGooods(LikeQueryGoods_Data data) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buypop_close:
                    pwindow.dismiss();
            break;
            case R.id.buypop_jian:
                if (Integer.parseInt(buypop_number.getText().toString()) == 1) {
                } else {
                    buypop_number.setText(Integer.parseInt(buypop_number.getText().toString()) - 1 + "");
                }

                break;
            case R.id.buypop_add:
                if (Integer.parseInt(buypop_number.getText().toString()) >= 99) {
                    Toast.makeText(Act_SingleGoodsInfo.this, "单次购买最大上限99！", Toast.LENGTH_SHORT).show();
                } else {
                    buypop_number.setText(Integer.parseInt(buypop_number.getText().toString()) + 1 + "");
                }

                break;
            case R.id.buypop_sure:
                userCartPerImpl.sendAddBuyCarTo(Constants.INSERTGOODS_USERCART_URL+userName+"&goodsId="+QuanJuData.getGoodsInfo().getGoodsId().toString().trim()+"&orderNum="+buypop_number.getText().toString().trim());
                break;



        }
    }


    @Override
    public void showAddBuyCarTo(boolean bool) {
        if(bool){
            Toast.makeText(Act_SingleGoodsInfo.this, "成功添加购物车！", Toast.LENGTH_SHORT).show();
            pwindow.dismiss();
        }
    }

    @Override
    public void showInsertCart(boolean bool) {

    }

    @Override
    public void showWaitPayOrder(Order_data data) {

    }


}
