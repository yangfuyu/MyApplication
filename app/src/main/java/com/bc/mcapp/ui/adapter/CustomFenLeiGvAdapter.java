package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.goodssort.Goods;
import com.bc.mcapp.utils.Constants;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admins on 2016/10/18.
 */
public class CustomFenLeiGvAdapter extends BaseAdapter {
    private Context context;
    private Conditions_data data;
    private int selectPosition = 0;


    public void changeSelected(int positon) {//刷新方法
        selectPosition = positon;
        notifyDataSetChanged();

    }

    public CustomFenLeiGvAdapter(Context context, Conditions_data data) {
        super();
        this.context = context;
        this.data=data;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.getData().size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.fgm_first_fenlei_gv_item, null);
            x.view().inject(viewHolder,convertView);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        x.image().bind(viewHolder.ivGoods, Constants.IMG_URL+data.getData().get(position).getGoodsPicList().get(0).getIcon());
        viewHolder.tvGoodsName.setText(data.getData().get(position).getGoodsName());
        return convertView;
    }

    class ViewHolder {
        @ViewInject(R.id.fgm_fenlei_gvItem_tv)
        TextView tvGoodsName;
        @ViewInject(R.id.fgm_fenlei_gvItem_iv)
        ImageView ivGoods;
    }
}
