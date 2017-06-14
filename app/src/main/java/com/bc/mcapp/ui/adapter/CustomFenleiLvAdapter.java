package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bc.mcapp.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by admins on 2016/10/17.
 */
public class CustomFenleiLvAdapter extends BaseAdapter {
    private Context context;
    String[] arrayList;

    public CustomFenleiLvAdapter(Context context,String[] arrayList) {
        super();
        this.context = context;
        this.arrayList=arrayList;


    }

    @Override
    public int getCount() {
        return arrayList.length;

    }

    @Override
    public Object getItem(int position) {
        return arrayList[position];
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
            convertView= LayoutInflater.from(context).inflate(R.layout.fgm_first_fenlei_lv_item,null);
            convertView.setTag(holder);
            x.view().inject(holder,convertView);
        }else{
            holder= (viewHolder) convertView.getTag();
        }

        holder.tv.setText(arrayList[position]);

        return convertView;
    }


    class viewHolder{
            @ViewInject(R.id.fgm_fenlei_lvItem_tv)
            TextView tv;
    }

}
