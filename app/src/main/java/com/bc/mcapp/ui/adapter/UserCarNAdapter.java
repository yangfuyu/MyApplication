package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.common.CustomListView;
import com.bc.mcapp.common.MyListView;
import com.bc.mcapp.entity.order.Order_data;
import com.bc.mcapp.entity.usercar.DataObject;
import com.bc.mcapp.presenter.UserCartPerImpl;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.UserCart;
import com.bumptech.glide.Glide;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admins on 2016/10/23.
 */
public class UserCarNAdapter extends BaseAdapter implements UserCart {
    Context context;
    ArrayList<DataObject> listUser;
    TextView fgm_bc_AllPrice, fgm_bc_AllGoodsNums;
    UserCartPerImpl userCartPerImpl;
    CustomListView fgm_bc_listview;
    ArrayList<HashMap<String,Integer>> listbool=new ArrayList<HashMap<String,Integer>>();
    CheckBox fgm_bc_CkboxAll;
    Button fgm_bc_JieSuan;

    int num = 0;

    HashMap<String,Integer> map;

    public UserCarNAdapter(Context context, ArrayList<DataObject> listUser, TextView fgm_bc_AllPrice, TextView fgm_bc_AllGoodsNums, CustomListView fgm_bc_listview, CheckBox fgm_bc_CkboxAll, Button fgm_bc_JieSuan) {
        this.context = context;
        this.listUser = listUser;
        this.fgm_bc_listview = fgm_bc_listview;
        this.fgm_bc_AllGoodsNums = fgm_bc_AllGoodsNums;
        this.fgm_bc_AllPrice = fgm_bc_AllPrice;
        this.fgm_bc_CkboxAll=fgm_bc_CkboxAll;
        this.fgm_bc_JieSuan=fgm_bc_JieSuan;
        userCartPerImpl = new UserCartPerImpl();
        userCartPerImpl.setUserCart(this);

    }


    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public Object getItem(int position) {
        return listUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(listUser.get(position).getGoods().getGoodsId());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final myViewHolder holder;
        if (convertView == null) {
            holder = new myViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.fgm_buycar_lv_itemnor, null);
            x.view().inject(holder, convertView);
            holder.fgm_bc_tvGoodsN_Nums.setTag(convertView);
            convertView.setTag(holder);
        } else {
            holder = (myViewHolder) convertView.getTag();
        }

        holder.fgm_bc_lvItemN_tvGoodName.setText(listUser.get(position).getGoods().getGoodsName());
        holder.fgm_bc_lvItemN_tvGoodInfo.setText(listUser.get(position).getGoods().getGoodsDesc());
        holder.fgm_bc_tvGoodsN_Price.setText(listUser.get(position).getGoods().getNewPrice());
        holder.fgm_bc_tvGoodsN_Nums.setText(listUser.get(position).getOrderNum());
        Glide.with(context).load(Constants.IMG_URL + listUser.get(position).getGoods().getGoodsPicList().get(0).getIcon()).placeholder(R.mipmap.ic_launcher).into(holder.fgm_bc_lvItemN_ivGoods);



        /////编辑
        holder.fgm_bc_lvItemN_tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 0) {
                    holder.fgm_bc_lvItemN_tvOk.setText("完成");
                    holder.fgm_bc_lvItemSlin.setVisibility(View.VISIBLE);
                    holder.fgm_bc_lvItemNlin.setVisibility(View.GONE);
                    holder.fgm_bc_et_nums.setText(holder.fgm_bc_tvGoodsN_Nums.getText());
                    num = 1;
                } else {
                    /////更改购物车数据
                    userCartPerImpl.sendInsertCartInfo(Constants.UPDATECARTINFO + listUser.get(position).getGoods().getGoodsId() + "&orderNum=" + holder.fgm_bc_et_nums.getText().toString());
                    holder.fgm_bc_lvItemN_tvOk.setText("编辑");
                    holder.fgm_bc_lvItemSlin.setVisibility(View.GONE);
                    holder.fgm_bc_lvItemNlin.setVisibility(View.VISIBLE);
                    num = 0;
                }
            }
        });



        ////checkbox
        holder.fgm_bc_lvItemN_Ckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    fgm_bc_JieSuan.setEnabled(true);
                    fgm_bc_JieSuan.setBackgroundResource(R.drawable.dialog_btn);
                    int singlePrice = Integer.parseInt(holder.fgm_bc_tvGoodsN_Price.getText().toString());
                    int goodsNums = Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString());
                    int singleAllPrice = singlePrice * goodsNums;
                    int tvAllPrice=Integer.parseInt(fgm_bc_AllPrice.getText().toString());////textview显示的总价
                    /////显示价格
                    fgm_bc_AllPrice.setText(String.valueOf(tvAllPrice+ singleAllPrice));
                    /////显示数量
                     int AllNums= Integer.parseInt(fgm_bc_AllGoodsNums.getText().toString());
                    fgm_bc_AllGoodsNums.setText(String.valueOf(AllNums + goodsNums));
                    buttonView.setChecked(true);

                    /////判断是否所有子item里的checkbox是否都被选中
                    listbool.clear();
                    for (int i = 0; i <listUser.size() ; i++) {
                        CheckBox cb= (CheckBox) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemN_Ckbox);
                        if(cb.isChecked()){
                            map=new HashMap<String, Integer>();
                            map.put("id",position);
                            listbool.add(map);
                        }
                    }
                    if(listbool.size() == listUser.size()){
                        fgm_bc_CkboxAll.setChecked(true);
                    }else{
                        fgm_bc_CkboxAll.setChecked(false);
                    }

                } else {


                    int singlePrice = Integer.parseInt(holder.fgm_bc_tvGoodsN_Price.getText().toString());
                    int goodsNums = Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString());
                    int singleAllPrice = singlePrice * goodsNums;
                    int tvAllPrice=Integer.parseInt(fgm_bc_AllPrice.getText().toString());////textview显示的总价
                    /////显示价格
                    fgm_bc_AllPrice.setText(String.valueOf(tvAllPrice - singleAllPrice));
                    /////显示数量
                    int AllNums= Integer.parseInt(fgm_bc_AllGoodsNums.getText().toString());
                    fgm_bc_AllGoodsNums.setText(String.valueOf(AllNums - goodsNums));
                    buttonView.setChecked(false);


                    listbool.clear();
                    for (int i = 0; i <listUser.size() ; i++) {
                        CheckBox cb= (CheckBox) fgm_bc_listview.getChildAt(i).findViewById(R.id.fgm_bc_lvItemN_Ckbox);
                        if(cb.isChecked()){
                            map=new HashMap<String, Integer>();
                            map.put("id",position);
                            listbool.add(map);
                        }
                    }
                    if(listbool.size() < listUser.size()){

                        fgm_bc_CkboxAll.setChecked(false);
                    }
                    if(listbool.size()== 0){
                        fgm_bc_JieSuan.setEnabled(false);
                        fgm_bc_JieSuan.setBackgroundResource(R.drawable.login_tv_bg);
                    }


                }
            }
        });


        /////减
        holder.fgm_bc_lvItemS_btnJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString()) == 1) {
                } else {
                    holder.fgm_bc_et_nums.setText(Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString()) - 1 + "");
                    holder.fgm_bc_tvGoodsN_Nums.setText(holder.fgm_bc_et_nums.getText());
                }

            }
        });

        ////加
        holder.fgm_bc_lvItemS_btnJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString()) == 99) {
                    Toast.makeText(context, "已达到一次购买上限！", Toast.LENGTH_SHORT).show();
                } else {
                    holder.fgm_bc_et_nums.setText(Integer.parseInt(holder.fgm_bc_tvGoodsN_Nums.getText().toString()) + 1 + "");
                    holder.fgm_bc_tvGoodsN_Nums.setText(holder.fgm_bc_et_nums.getText());
                }
            }
        });

        holder.fgm_bc_lvItemS_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }




    @Override
    public void showInsertCart(boolean bool) {
        if (bool) {
            Toast.makeText(context, "修改成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "修改失败！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showWaitPayOrder(Order_data data) {

    }

    @Override
    public void showAddBuyCarTo(boolean bool) {

    }


    class myViewHolder {
        @ViewInject(R.id.fgm_bc_lvItemN_tvOk)
        TextView fgm_bc_lvItemN_tvOk;
        @ViewInject(R.id.fgm_bc_lvItemN_tvGoodName)
        TextView fgm_bc_lvItemN_tvGoodName;
        @ViewInject(R.id.fgm_bc_lvItemN_tvGoodInfo)
        TextView fgm_bc_lvItemN_tvGoodInfo;
        @ViewInject(R.id.fgm_bc_tvGoodsN_Price)
        TextView fgm_bc_tvGoodsN_Price;
        @ViewInject(R.id.fgm_bc_tvGoodsN_Nums)
        TextView fgm_bc_tvGoodsN_Nums;
        @ViewInject(R.id.fgm_bc_lvItemN_ivGoods)
        ImageView fgm_bc_lvItemN_ivGoods;
        @ViewInject(R.id.fgm_bc_lvItemN_Ckbox)
        CheckBox fgm_bc_lvItemN_Ckbox;
        @ViewInject(R.id.fgm_bc_lvItemSlin)
        LinearLayout fgm_bc_lvItemSlin;
        @ViewInject(R.id.fgm_bc_lvItemNlin)
        LinearLayout fgm_bc_lvItemNlin;
        @ViewInject(R.id.fgm_bc_lvItemS_btnJian)
        Button fgm_bc_lvItemS_btnJian;
        @ViewInject(R.id.fgm_bc_lvItemS_btnJia)
        Button fgm_bc_lvItemS_btnJia;
        @ViewInject(R.id.fgm_bc_et_nums)
        EditText fgm_bc_et_nums;
        @ViewInject(R.id.fgm_bc_lvItemS_Delete)
        Button fgm_bc_lvItemS_Delete;


    }


}
