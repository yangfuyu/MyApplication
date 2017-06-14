package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.utils.Constants;
import com.bumptech.glide.Glide;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/18.
 */
public class FgmHomeGrid3Adapter extends BaseAdapter {
    Context context;
    ArrayList<DataFirstObject> listTSGrid1;
    public FgmHomeGrid3Adapter(Context context, ArrayList<DataFirstObject> listTSGrid1){
            this.context=context;
            this.listTSGrid1=listTSGrid1;
    }

    @Override
    public int getCount() {
        return listTSGrid1.size();
    }

    @Override
    public Object getItem(int position) {
        return listTSGrid1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if(convertView == null){
            holder=new viewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.home_gridview3_item,null);
            convertView.setTag(holder);
            x.view().inject(holder,convertView);

        }else{
            holder= (viewHolder) convertView.getTag();
        }
        holder.home_grid3_item_tv1.setText(listTSGrid1.get(position).getGoodsName());
        holder.home_grid3_item_tv2.setText(listTSGrid1.get(position).getTitle());

        Glide.with(context).load(Constants.IMG_URL +  listTSGrid1.get(position).getGoodsPicList().get(0).getIcon()).placeholder(R.mipmap.ic_launcher).into(holder.home_grid3_item_iv);
        return convertView;
    }



    class viewHolder{
        @ViewInject(R.id.home_grid3_item_tv1)
        TextView home_grid3_item_tv1;
        @ViewInject(R.id.home_grid3_item_tv2)
        TextView home_grid3_item_tv2;
        @ViewInject(R.id.home_grid3_item_iv)
        ImageView home_grid3_item_iv;
    }

    public  void setDataChange(ArrayList<DataFirstObject> listTSGrid1){
            this.listTSGrid1=listTSGrid1;
        notifyDataSetChanged();
    }

}
