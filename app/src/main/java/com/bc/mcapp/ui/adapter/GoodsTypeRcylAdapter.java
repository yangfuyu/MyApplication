package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bc.mcapp.R;
import com.bc.mcapp.common.TypeViewHolder;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.utils.Constants;

import org.xutils.x;

/**
 * Created by admins on 2016/10/21.
 */
public class GoodsTypeRcylAdapter extends RecyclerView.Adapter<TypeViewHolder> {
    Context context;
   Conditions_data data;
    public GoodsTypeRcylAdapter( Context context,Conditions_data data){
        this.context=context;
        this.data=data;
    }

    @Override
    public TypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fgm_goodsinfo_item,parent,false);
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TypeViewHolder holder,final int position) {
        holder.fgm_gods_imTvGoods.setText(data.getData().get(position).getGoodsName());
        holder.fgm_gods_imTvMoeny.setText("￥"+data.getData().get(position).getNewPrice());
        x.image().bind(holder.fgm_gods_imIvGoods, Constants.IMG_URL+data.getData().get(position).getGoodsPicList().get(0).getIcon());

    }

    @Override
    public int getItemCount() {
        return data.getData().size();
    }

}
