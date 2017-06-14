package com.bc.mcapp.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bc.mcapp.R;

/**
 * Created by admins on 2016/10/21.
 */
public class TypeViewHolder extends RecyclerView.ViewHolder {
   public TextView fgm_gods_imTvGoods;
    public TextView fgm_gods_imTvMoeny;
    public ImageView fgm_gods_imIvGoods;

    public TypeViewHolder(View itemView) {
        super(itemView);
        fgm_gods_imIvGoods= (ImageView) itemView.findViewById(R.id.fgm_gods_imIvGoods);
        fgm_gods_imTvGoods= (TextView) itemView.findViewById(R.id.fgm_gods_imTvGoods);
        fgm_gods_imTvMoeny= (TextView) itemView.findViewById(R.id.fgm_gods_imTvMoeny);

    }


}
