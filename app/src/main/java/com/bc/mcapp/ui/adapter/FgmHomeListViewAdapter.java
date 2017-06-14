package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.utils.Constants;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/18.
 */
public class FgmHomeListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<DataFirstObject> listTSGrid1;
    ArrayList<String> list=new ArrayList<String>();
    public FgmHomeListViewAdapter(Context context, ArrayList<DataFirstObject> listTSGrid1){
            this.context=context;
            this.listTSGrid1=listTSGrid1;
        for (DataFirstObject li:listTSGrid1 ) {
              list.add( li.getGoodsPicList().get(0).getIcon());
        }


    }

    @Override
    public int getCount() {
        return 3;
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
            convertView= LayoutInflater.from(context).inflate(R.layout.home_list_item,null);
            convertView.setTag(holder);
            x.view().inject(holder,convertView);

        }else{
            holder= (viewHolder) convertView.getTag();
        }
        holder.home_listview_item_tv1.setText(listTSGrid1.get(position+1).getGoodsName());
        holder.home_listview_item_tv2.setText(listTSGrid1.get(position+1).getTitle());
        x.image().bind(holder.home_listview_item_iv1, Constants.IMG_URL + list.get(position+1));
        return convertView;
    }



    class viewHolder{
        @ViewInject(R.id.home_listview_item_tv1)
        TextView home_listview_item_tv1;
        @ViewInject(R.id.home_listview_item_tv2)
        TextView home_listview_item_tv2;
        @ViewInject(R.id.home_listview_item_iv1)
        ImageView home_listview_item_iv1;
    }


}
