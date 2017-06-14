package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.ui.fragment.GoodsMoneyFgm;
import com.bc.mcapp.ui.fragment.GoodsTypeFgm;
import com.bc.mcapp.ui.fragment.GoodsXiaoLiangFgm;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.GoodsInfo;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by admins on 2016/10/21.
 */
@ContentView(R.layout.fgm_allgoodsinfo)
public class GoodsInfoActivity  extends Activity implements View.OnClickListener{
    FragmentManager fm;
    FragmentTransaction ft;
    GoodsTypeFgm fgm1;
    GoodsXiaoLiangFgm fgm2;
    GoodsMoneyFgm fgm3;
    PopupWindow popupw;
    View view;
    int frameHeith,frameWith;
    ImageView fgm_gods_Back;
    TextView fgm_gods_OK;
   public String index;
    @ViewInject(R.id.fgm_goodsInfo_tv4)
    TextView fgm_goodsInfo_tv4;



    boolean bol=true;
    boolean  bo=true;
    boolean xo=true;
    boolean xo2=true;
    public boolean sendDataBoolean=false;
    public boolean sendBoolean2=false;
    /*控制侧滑菜单*/
    DrawerLayout drawer;
    LinearLayout linyout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getFragmentData();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       linyout= (LinearLayout) findViewById(R.id.drawer_content);
        fgm_gods_Back= (ImageView) drawer.findViewById(R.id.fgm_gods_Back);
        fgm_gods_OK= (TextView) drawer.findViewById(R.id.fgm_gods_OK);

        Intent intent=getIntent();
        boolean bo=intent.getBooleanExtra("goodsBool",false);
        if(bo){
           index=intent.getStringExtra("goodsId");
        }



    }


    private void initPopupWindow() {
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        frameHeith = display.getHeight() ;
        frameWith = display.getWidth() ;
        view=View.inflate(this, R.layout.fgm_gods_select_pupw, null);

        popupw=new PopupWindow(view, frameWith-50,ViewGroup.LayoutParams.MATCH_PARENT);
         fgm_gods_Back= (ImageView) view.findViewById(R.id.fgm_gods_Back);
        fgm_gods_OK= (TextView) view.findViewById(R.id.fgm_gods_OK);


        fgm_gods_Back.setOnClickListener(this);
        fgm_gods_OK.setOnClickListener(this);
    }


    /////touch事件，当touch在非内容区域时，popup窗口关闭
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!super.onTouchEvent(event)) {
            if (event.getAction() == event.ACTION_UP) {

            }
        }
        return true;
    }

    private void getFragmentData(){
        fm=getFragmentManager();
        ft=fm.beginTransaction();
        fgm1=new GoodsTypeFgm();
        fgm2=new GoodsXiaoLiangFgm();
        fgm3=new GoodsMoneyFgm();

        ft.add(R.id.lin_goods,fgm1);
        ft.add(R.id.lin_goods,fgm2);
        ft.add(R.id.lin_goods,fgm3);
        ft.commit();
    }

    @Event(value = {R.id.fgm_goodsInfo_tv1,R.id.fgm_goodsInfo_tv2,R.id.fgm_goodsInfo_tv3,R.id.fgm_goodsInfo_tv4},type = View.OnClickListener.class)
    private void myOnClick(View v){
        switch (v.getId()){
            case R.id.fgm_goodsInfo_tv1:
                ft=fm.beginTransaction();
                ft.show(fgm1);
                ft.hide(fgm2);
                ft.hide(fgm3);
                ft.commit();
                bol=false;
                xo=false;
            break;
            case R.id.fgm_goodsInfo_tv2:
                ft=fm.beginTransaction();
                ft.show(fgm2);
                ft.hide(fgm1);
                ft.hide(fgm3);
                ft.commit();

                if(bol){
                    if(bo){
                        sendDataBoolean=true;
                        bo=false;
                    }else{
                        sendDataBoolean=false;
                        bo=true;
                    }
                }

                xo=false;

                break;
            case R.id.fgm_goodsInfo_tv3:
                ft=fm.beginTransaction();
                ft.show(fgm3);
                ft.hide(fgm2);
                ft.hide(fgm1);
                ft.commit();
                bol=false;

                if(xo){
                    if(xo2){
                        sendBoolean2=true;
                        xo2=false;
                    }else{
                        sendBoolean2=false;
                        xo2=true;
                    }
                }
                break;
            case R.id.fgm_goodsInfo_tv4:
                drawer.openDrawer(linyout);
                bol=false;
                xo=false;
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fgm_gods_Back:
                drawer.closeDrawer(linyout);
                break;
            case R.id.fgm_gods_OK:
                drawer.closeDrawer(linyout);
                break;
        }

    }






}
