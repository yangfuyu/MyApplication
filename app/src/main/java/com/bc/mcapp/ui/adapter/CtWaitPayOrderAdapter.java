package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.order.OrderListObject;
import com.bc.mcapp.utils.Constants;
import com.bumptech.glide.Glide;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/11/2.
 */
public class CtWaitPayOrderAdapter extends BaseAdapter {
    Context context;
    ArrayList<OrderListObject> orderList;


    public CtWaitPayOrderAdapter(Context context, ArrayList<OrderListObject> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.act_orderpay_item, null);
            holder = new ViewHolder();
            x.view().inject(holder, convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.DingDan_GoodName.setText(orderList.get(position).getGoods().getGoodsName());
        holder.DingDan_GoodsInfo.setText(orderList.get(position).getGoods().getGoodsDesc());
        holder.DingDan_ShopPrice.setText(orderList.get(position).getGoods().getNewPrice());
        holder.DingDan_ShopNum.setText("X "+orderList.get(position).getOnum());
        holder.DingDan_ShopAllNum.setText("共计："+orderList.get(position).getOnum()+"件");
        int singleGoodsPrice=Integer.parseInt(orderList.get(position).getGoods().getNewPrice());
        int singleGoodsNums=Integer.parseInt(orderList.get(position).getOnum());
        int allMoney=singleGoodsPrice * singleGoodsNums;
        holder.DingDan_ShopAllPrice.setText(allMoney+"");
        Glide.with(context).load(Constants.IMG_URL+orderList.get(position).getGoods().getGoodsPicList().get(0).getIcon())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.DingDan_ImageView);

        return convertView;
    }

    class ViewHolder {
        @ViewInject(R.id.DingDan_GoodName)
        TextView DingDan_GoodName;
        @ViewInject(R.id.DingDan_GoodsInfo)
        TextView DingDan_GoodsInfo;
        @ViewInject(R.id.DingDan_ShopPrice)
        TextView DingDan_ShopPrice;
        @ViewInject(R.id.DingDan_ShopAllNum)
        TextView DingDan_ShopAllNum;
        @ViewInject(R.id.DingDan_ShopNum)
        TextView DingDan_ShopNum;
        @ViewInject(R.id.DingDan_ShopAllPrice)
        TextView DingDan_ShopAllPrice;
        @ViewInject(R.id.DingDan_ImageView)
        ImageView DingDan_ImageView;


    }


}
