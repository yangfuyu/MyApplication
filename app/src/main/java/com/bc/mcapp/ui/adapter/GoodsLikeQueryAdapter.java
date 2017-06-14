package com.bc.mcapp.ui.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.listquerygoodds.QueryData;
import com.bc.mcapp.ui.activity.Act_SingleGoodsInfo;
import com.bc.mcapp.utils.IsIntentUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/31.
 */
public class GoodsLikeQueryAdapter extends BaseAdapter {
    Context context;
    ArrayList<QueryData> listLike;

    public GoodsLikeQueryAdapter(Context context, ArrayList<QueryData> listLike) {
        this.context = context;
        this.listLike = listLike;
    }


    @Override
    public int getCount() {
        return listLike.size();
    }

    @Override
    public Object getItem(int position) {
        return listLike.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        myViewHolder holder;
        if(convertView == null){
            holder=new myViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.act_search_comein_item,null);
            x.view().inject(holder,convertView);
            convertView.setTag(holder);
        }else{
            holder= (myViewHolder) convertView.getTag();
        }
        holder.search_conitem_tvName.setText(listLike.get(position).getGoodsName());
        holder.search_conitem_tvTitle.setText(listLike.get(position).getTitle());
        holder.search_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Act_SingleGoodsInfo.class);
                intent.putExtra("goodsId",listLike.get(position).getGoodsId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }




    class myViewHolder{
        @ViewInject(R.id.search_conitem_tvName)
        TextView search_conitem_tvName;
        @ViewInject(R.id.search_conitem_tvTitle)
        TextView search_conitem_tvTitle;
        @ViewInject(R.id.search_lin)
        LinearLayout search_lin;
    }

}
