package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bc.mcapp.entity.detailgoods.GoodsPicListObject;
import com.bc.mcapp.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/31.
 */
public class GoodsSingleInfoVpAdapter extends PagerAdapter {
    Context context;
    ImageView img;
    ArrayList<GoodsPicListObject> list;
    ArrayList<ImageView> listview;
    public GoodsSingleInfoVpAdapter(Context context, ArrayList<GoodsPicListObject> list) {
        this.context = context;
        this.list = list;
        listview=new ArrayList<ImageView>();
        for (int i = 0; i <list.size() ; i++) {
            img=new ImageView(context);
            img.setAdjustViewBounds(true);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            listview.add(img);
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Glide.with(context).load(Constants.IMG_URL+list.get(position).getIcon()).into(listview.get(position));
        container.addView(listview.get(position));
        return listview.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(listview.get(position));
    }




}
