package com.bc.mcapp.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bc.mcapp.entity.homepager.DataObject;
import com.bc.mcapp.utils.Constants;

import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/16.
 */
public class FgmHomeTopVpAdapter extends PagerAdapter{
    Context context;
    ArrayList<DataObject> vpTopList;
    ArrayList<ImageView> list;

    public FgmHomeTopVpAdapter( Context context, ArrayList<DataObject> vpTopList){
            this.context=context;
            this.vpTopList=vpTopList;
    }

    @Override
    public int getCount() {
        return vpTopList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        list=new ArrayList<ImageView>();
        for (DataObject li:vpTopList ) {
            ImageView v=new ImageView(context);
            v.setTop(0);
            v.setAdjustViewBounds(true);
            v.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(v);
        }
        x.image().bind(list.get(position), Constants.IMG_URL+vpTopList.get(position).getAdIcon());
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
