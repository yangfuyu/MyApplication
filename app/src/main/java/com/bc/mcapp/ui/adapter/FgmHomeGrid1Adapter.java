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
public class FgmHomeGrid1Adapter extends BaseAdapter {
    Context context;
    ArrayList<DataFirstObject> listTSGrid1;
    ArrayList<String> list=new ArrayList<String>();
    public FgmHomeGrid1Adapter( Context context,ArrayList<DataFirstObject> listTSGrid1){
            this.context=context;
            this.listTSGrid1=listTSGrid1;
        for (DataFirstObject li:listTSGrid1 ) {
              list.add( li.getGoodsPicList().get(0).getIcon());
        }

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
            convertView= LayoutInflater.from(context).inflate(R.layout.home_gridview1_item,null);
            convertView.setTag(holder);
            x.view().inject(holder,convertView);

        }else{
            holder= (viewHolder) convertView.getTag();
        }
        holder.tvNewPrice.setText("￥"+listTSGrid1.get(position).getNewPrice());
        holder.tvOldPrice.setText("￥"+listTSGrid1.get(position).getOldPrice());
        x.image().bind(holder.goodsIv, Constants.IMG_URL + list.get(position));
        return convertView;
    }



    class viewHolder{
        @ViewInject(R.id.home_grid1_item_tv1)
        TextView tvNewPrice;
        @ViewInject(R.id.home_grid1_item_tv2)
        TextView tvOldPrice;
        @ViewInject(R.id.home_grid1_item_iv1)
        ImageView goodsIv;
    }


}
