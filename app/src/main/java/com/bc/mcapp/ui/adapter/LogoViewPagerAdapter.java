package com.bc.mcapp.ui.adapter;

import java.util.ArrayList;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


public class LogoViewPagerAdapter extends PagerAdapter {
	private ArrayList<View> list;
	Context context;
	public LogoViewPagerAdapter(Context context,ArrayList<View> list){
		this.context=context;
		this.list=list;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View v, Object o) {
		// TODO Auto-generated method stub
		return v == o;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(list.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(list.get(position));
		return list.get(position);
	}
	
	
	
	

}
