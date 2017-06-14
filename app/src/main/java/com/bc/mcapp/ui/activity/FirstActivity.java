package com.bc.mcapp.ui.activity;

import org.xutils.x;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.ui.fragment.FirstBuyCarFgm;
import com.bc.mcapp.ui.fragment.FirstFenLeiFgm;
import com.bc.mcapp.ui.fragment.FirstHomeFgm;
import com.bc.mcapp.ui.fragment.FirstMeFgm;

@ContentView(R.layout.act_first)
public class FirstActivity extends Activity {
	FirstHomeFgm fHome;
	FirstFenLeiFgm fFneLei;
	FirstBuyCarFgm fBuyCar;
	FirstMeFgm fMe;
	FragmentManager fm;
	FragmentTransaction ft;
	/*@ViewInject(R.id.act_first_IvHome)
	ImageView act_first_IvHome;
	@ViewInject(R.id.act_first_IvFenLei)
	ImageView act_first_IvFenLei;
	@ViewInject(R.id.act_first_IvBuyCar)
	ImageView act_first_IvBuyCar;
	@ViewInject(R.id.act_first_IvMe)
	ImageView act_first_IvMe;*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x.view().inject(this);
		getFragment();
	}
	
	
	private void getFragment(){
		fHome=new FirstHomeFgm();
		fFneLei=new FirstFenLeiFgm();
		fBuyCar=new FirstBuyCarFgm();
		fMe=new FirstMeFgm();
		
		fm=getFragmentManager();
			ft=fm.beginTransaction();
		
		ft.add(R.id.act_first_linContent, fHome);
		ft.add(R.id.act_first_linContent, fFneLei);
		ft.add(R.id.act_first_linContent, fBuyCar);
		ft.add(R.id.act_first_linContent, fMe);
		
		ft.show(fHome);
		ft.hide(fFneLei);
		ft.hide(fBuyCar);
		ft.hide(fMe);
		ft.commit();
		
	}
	
	@Event(value={R.id.act_first_IvHome,R.id.act_first_IvFenLei,R.id.act_first_IvBuyCar,R.id.act_first_IvMe},type=OnClickListener.class)
	private void onFragmentClick(View v){
		switch (v.getId()){
			case R.id.act_first_IvHome:
				ft=fm.beginTransaction();
				ft.show(fHome);
				ft.hide(fFneLei);
				ft.hide(fBuyCar);
				ft.hide(fMe);
				ft.commit();

			break;
			case R.id.act_first_IvFenLei:
				ft=fm.beginTransaction();
				ft.show(fFneLei);
				ft.hide(fHome);
				ft.hide(fBuyCar);
				ft.hide(fMe);
				ft.commit();

				break;

			case R.id.act_first_IvBuyCar:
				fBuyCar=new FirstBuyCarFgm();
				ft=fm.beginTransaction();
				ft.add(R.id.act_first_linContent, fBuyCar);
				ft.show(fBuyCar);
				ft.hide(fHome);
				ft.hide(fFneLei);
				ft.hide(fMe);
				ft.commit();

				break;
			case R.id.act_first_IvMe:
				ft=fm.beginTransaction();
				ft.show(fMe);
				ft.hide(fFneLei);
				ft.hide(fBuyCar);
				ft.hide(fHome);
				ft.commit();

				break;
		}

		
	}
	
	
	
}
