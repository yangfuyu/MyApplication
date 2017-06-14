package com.bc.mcapp.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bc.mcapp.R;

/**
 * Created by admins on 2016/10/21.
 */
public class MyListViewHolder extends RecyclerView.ViewHolder {
    public TextView fgm_gods_lvTvGoodsN,fgm_gods_lvTvGoodsP;
    public ImageView fgm_gods_lvIvGoods;

    public MyListViewHolder(View itemView) {
        super(itemView);
        fgm_gods_lvTvGoodsN= (TextView) itemView.findViewById(R.id.fgm_gods_lvTvGoodsN);
        fgm_gods_lvTvGoodsP= (TextView) itemView.findViewById(R.id.fgm_gods_lvTvGoodsP);
        fgm_gods_lvIvGoods= (ImageView) itemView.findViewById(R.id.fgm_gods_lvIvGoods);

    }



}
