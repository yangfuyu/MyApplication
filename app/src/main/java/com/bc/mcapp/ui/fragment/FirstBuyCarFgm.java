package com.bc.mcapp.ui.fragment;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import com.bc.mcapp.R;
import com.bc.mcapp.common.CustomListView;
import com.bc.mcapp.entity.usercar.DataObject;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.presenter.UserPresenerImpl;
import com.bc.mcapp.ui.activity.Act_OrderPay;
import com.bc.mcapp.ui.adapter.UserCarNAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.UserShowLogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstBuyCarFgm extends Fragment implements UserShowLogin {
    View view;
    String userName;
    boolean bo;
    @ViewInject(R.id.fgm_bc_listview)
    CustomListView fgm_bc_listview;
    @ViewInject(R.id.fgm_bc_CkboxAll)
    CheckBox fgm_bc_CkboxAll;
    @ViewInject(R.id.fgm_bc_AllGoodsNums)
    TextView fgm_bc_AllGoodsNums;
    @ViewInject(R.id.fgm_bc_AllPrice)
    TextView fgm_bc_AllPrice;
    @ViewInject(R.id.fgm_bc_JieSuan)
    Button fgm_bc_JieSuan;
    UserPresenerImpl userPresenerImpl;
    ArrayList<DataObject> listUser;
    @ViewInject(R.id.fgm_bc_tvEdit)
    TextView fgm_bc_tvEdit;
    int tagNum = 0;
    UserCarNAdapter adapterN;
    @ViewInject(R.id.fgm_bc_tvTip)
    TextView fgm_bc_tvTip;
    @ViewInject(R.id.fgm_bc_scroll)
    ScrollView fgm_bc_scroll;
    String goodsIdNum;

    int priceAll;
    private StringBuilder sb, sb2;
    int all;
    int ckbox = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fgm_first_buycars, null);
        }
        ViewGroup parent=(ViewGroup) view.getParent();
        if(parent!=null){
            parent.removeView(view);
        }

        x.view().inject(this, view);
        userPresenerImpl = new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sh = getActivity().getSharedPreferences("LoginSuccess", Context.MODE_PRIVATE);
        userName = sh.getString("LoginSuccessName", "noUser");
        bo = sh.getBoolean("LoginSuccessBool", false);

        if (bo) {
            fgm_bc_tvTip.setVisibility(View.GONE);
            userPresenerImpl.userQueryUserCar(Constants.QUERYUSERCAR_URL + userName);
        } else {
            fgm_bc_tvTip.setVisibility(View.VISIBLE);
            fgm_bc_tvTip.setGravity(Gravity.CENTER);
            fgm_bc_scroll.setVisibility(View.GONE);
        }
    }


    @Override
    public void showUserLogin(boolean bool) {

    }

    @Override
    public void showAddUser(boolean boo) {

    }

    @Override
    public void showUserDenglu(boolean boo, String name) {

    }

    @Override
    public void showUpdateName(boolean bool) {

    }

    @Override
    public void showUpdatePwd(boolean bool) {

    }

    @Override
    public void showUpdateSex(boolean bool) {

    }

    @Override
    public void showQueryUserCar(UserCar_data data) {
        if (data != null) {

            listUser = data.getGetCarts().getData();

            adapterN = new UserCarNAdapter(getActivity(), listUser, fgm_bc_AllPrice, fgm_bc_AllGoodsNums, fgm_bc_listview,fgm_bc_CkboxAll, fgm_bc_JieSuan);
            fgm_bc_scroll.setVisibility(View.VISIBLE);
            /////编辑全部
            fgm_bc_tvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (tagNum == 0) {
                        fgm_bc_tvEdit.setText("完成");
                        for (int i = 0; i < listUser.size(); i++) {
                            ////显示编辑布局
                            View view = fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemSlin);
                            view.setVisibility(View.VISIBLE);
                            EditText etShowNums= (EditText) view.findViewById(R.id.fgm_bc_et_nums);
                            etShowNums.setText(listUser.get(i).getOrderNum());

                            /////隐藏详情布局
                            View view2 = fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemNlin);
                            view2.setVisibility(View.GONE);

                        }
                        tagNum = 1;
                    } else {
                        fgm_bc_tvEdit.setText("编辑");
                        for (int i = 0; i < listUser.size(); i++) {
                            ////隐藏编辑布局
                            View view = fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemSlin);
                            view.setVisibility(View.GONE);
                            ///////显示详情布局
                            View view2 = fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemNlin);
                            view2.setVisibility(View.VISIBLE);
                        }
                        tagNum = 0;
                    }
                }
            });


            /////全选
            fgm_bc_CkboxAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fgm_bc_CkboxAll.isChecked()) {
                        for (int i = 0; i < listUser.size(); i++) {
                            CheckBox chebox = (CheckBox) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemN_Ckbox);
                            chebox.setChecked(true);
                        }


                    } else {
                        for (int i = 0; i < listUser.size(); i++) {
                            CheckBox chebox = (CheckBox) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemN_Ckbox);
                            chebox.setChecked(false);
                        }

                    }

                }
            });

            fgm_bc_JieSuan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goodsIdNum="";
                    getData();//获取商品id和个数   拼接
                    RequestParams params=new RequestParams(Constants.DELETEORDER_URL);///清空
                    params.setMultipart(true);
                    x.http().get(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Toast.makeText(getActivity(), "wwww", Toast.LENGTH_SHORT).show();
                            ////添加购物车
                            RequestParams pa=new RequestParams(Constants.INSERTORDER_URL+userName+"&addressId=1&totalMoney="+fgm_bc_AllPrice.getText()+"&sendtype=abc&payType=bcd&detailList="+goodsIdNum);
                            x.http().get(pa, new CommonCallback<String>() {
                                @Override
                                public void onSuccess(String s) {
                                    try {
                                        JSONObject jo=new JSONObject(s);
                                        String jst=jo.getString("status");
                                        if(jst.equals("success")){
                                            Intent intent=new Intent(getActivity(), Act_OrderPay.class);
                                            intent.putExtra("uId",userName);
                                            startActivity(intent);
                                            fgm_bc_AllPrice.setText(0+"");
                                            fgm_bc_AllGoodsNums.setText(0+"");
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(Throwable throwable, boolean b) {

                                }

                                @Override
                                public void onCancelled(CancelledException e) {

                                }

                                @Override
                                public void onFinished() {

                                }
                            });

                        }

                        @Override
                        public void onError(Throwable throwable, boolean b) {

                        }

                        @Override
                        public void onCancelled(CancelledException e) {

                        }

                        @Override
                        public void onFinished() {

                        }
                    });

                }
            });
            fgm_bc_listview.setAdapter(adapterN);
        }
    }


        //获取商品id和个数   拼接
        private void getData(){
            for (int i = 0; i < fgm_bc_listview.getAdapter().getCount(); i++) {
                CheckBox cb = (CheckBox) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemN_Ckbox);
                TextView tv = (TextView) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_tvGoodsN_Nums);
                if(cb.isChecked()){
                    int goodsId = (int) fgm_bc_listview.getAdapter().getItemId(i);
                    String goodsNum = tv.getText().toString();
                    goodsIdNum += goodsId+"_"+goodsNum+",";
                }
            }


    }


}
