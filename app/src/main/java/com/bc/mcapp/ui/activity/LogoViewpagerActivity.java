package com.bc.mcapp.ui.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xutils.x;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bc.mcapp.R;
import com.bc.mcapp.ui.adapter.LogoViewPagerAdapter;

@ContentView(R.layout.act_logoviewpager)
public class LogoViewpagerActivity extends Activity {
	private ArrayList<View> list;
	View v1,v2,v3;
	@ViewInject(R.id.act_logovp)
	ViewPager logoVp;
	LogoViewPagerAdapter adapter;
	Button btnCome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
		
		adapter=new LogoViewPagerAdapter(this, getImageToViewPager());
		logoVp.setAdapter(adapter);
		onClick();
		
	}
	
	
	private void onClick(){
		btnCome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SharedPreferences sh=getSharedPreferences("logo",MODE_PRIVATE);
				SharedPreferences.Editor sd=sh.edit();
				sd.putBoolean("bool", true);
				sd.commit();
				Intent intent=new Intent(LogoViewpagerActivity.this,FirstActivity.class);
				startActivity(intent);
				LogoViewpagerActivity.this.finish();
			}
		});
		
	}

	
	private ArrayList<View>  getImageToViewPager(){
		list=new ArrayList<View>();
		list.add(v1=View.inflate(this, R.layout.act_logovp_one, null));
		list.add(v2=View.inflate(this, R.layout.act_logovp_two, null));
		list.add(v3=View.inflate(this, R.layout.act_logovp_three, null));

		btnCome=(Button) v3.findViewById(R.id.act_logo3_btnComein);
		return list;
	}
	
	
	
	
}
