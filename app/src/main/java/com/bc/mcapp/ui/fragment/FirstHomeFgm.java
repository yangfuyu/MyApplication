package com.bc.mcapp.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.common.CustomGridView;
import com.bc.mcapp.common.CustomGridView1;
import com.bc.mcapp.common.CustomScrollView;
import com.bc.mcapp.common.MyListView;
import com.bc.mcapp.common.PullToRefreshView;
import com.bc.mcapp.entity.homepager.DataFirstObject;
import com.bc.mcapp.entity.homepager.DataObject;
import com.bc.mcapp.entity.homepager.HomePager_data;
import com.bc.mcapp.presenter.FgmHomeImpl;
import com.bc.mcapp.ui.activity.Act_SearchClas;
import com.bc.mcapp.ui.activity.GoodsInfoActivity;
import com.bc.mcapp.ui.adapter.FgmHomeGrid1Adapter;
import com.bc.mcapp.ui.adapter.FgmHomeGrid2Adapter;
import com.bc.mcapp.ui.adapter.FgmHomeGrid3Adapter;
import com.bc.mcapp.ui.adapter.FgmHomeListViewAdapter;
import com.bc.mcapp.ui.adapter.FgmHomeTopVpAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.IsIntentUtils;
import com.bc.mcapp.utils.SetColumnWidth;
import com.bc.mcapp.view.ViewFgm_FirstHome;
import com.bumptech.glide.Glide;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class FirstHomeFgm extends Fragment implements ViewFgm_FirstHome,PullToRefreshView.OnHeaderRefreshListener,PullToRefreshView.OnFooterRefreshListener{
	View view;
	FgmHomeImpl homeImpl;
	ArrayList<DataObject> vpTopList;
	@ViewInject(R.id.home_vp)
	ViewPager topViewPager;
	@ViewInject(R.id.home_goods1_iv)
	ImageView home_goods1_iv;
	@ViewInject(R.id.home_goods1_tv1)
	TextView home_goods1_tv1;
	@ViewInject(R.id.home_goods1_tv2)
	TextView home_goods1_tv2;
	@ViewInject(R.id.home_goods2_iv)
	ImageView home_goods2_iv;
	@ViewInject(R.id.home_goods2_tv1)
	TextView home_goods2_tv1;
	@ViewInject(R.id.home_goods2_tv2)
	TextView home_goods2_tv2;
	@ViewInject(R.id.home_goods3_iv)
	ImageView home_goods3_iv;
	@ViewInject(R.id.home_goods3_tv1)
	TextView home_goods3_tv1;
	@ViewInject(R.id.home_goods3_tv2)
	TextView home_goods3_tv2;
	@ViewInject(R.id.home_goods4_iv)
	ImageView home_goods4_iv;
	@ViewInject(R.id.home_goods4_tv1)
	TextView home_goods4_tv1;
	@ViewInject(R.id.home_goods4_tv2)
	TextView home_goods4_tv2;
	@ViewInject(R.id.home_goods5_iv)
	ImageView home_goods5_iv;
	@ViewInject(R.id.home_goods5_tv1)
	TextView home_goods5_tv1;
	@ViewInject(R.id.home_goods5_tv2)
	TextView home_goods5_tv2;
	@ViewInject(R.id.home_goods6_iv)
	ImageView home_goods6_iv;
	@ViewInject(R.id.home_goods6_tv1)
	TextView home_goods6_tv1;
	@ViewInject(R.id.home_goods6_tv2)
	TextView home_goods6_tv2;
	@ViewInject(R.id.home_goods7_iv)
	ImageView home_goods7_iv;
	@ViewInject(R.id.home_goods7_tv1)
	TextView home_goods7_tv1;
	@ViewInject(R.id.home_goods7_tv2)
	TextView home_goods7_tv2;
	@ViewInject(R.id.home_goods8_iv)
	ImageView home_goods8_iv;
	@ViewInject(R.id.home_goods8_tv1)
	TextView home_goods8_tv1;
	@ViewInject(R.id.home_goods8_tv2)
	TextView home_goods8_tv2;
	@ViewInject(R.id.home_Grid2)
	CustomGridView customGridView1;
	@ViewInject(R.id.home_Listview)
	MyListView home_Listview;
	@ViewInject(R.id.homegrid3)
	CustomGridView1 customGridView2;
	FgmHomeListViewAdapter fgmHomeListViewAdapter;
	FgmHomeTopVpAdapter topVpadapter;
	FgmHomeGrid1Adapter fgmHomeGrid1Adapter;
	FgmHomeGrid2Adapter fgmHomeGrid2Adapter;
	FgmHomeGrid3Adapter fgmHomeGrid3Adapter;
	Handler handler=new Handler();
	int indexvp;
	myThread runs;
	ArrayList<DataFirstObject> listTSGrid1,listTwo,listTBThree,listFour;
	ArrayList<DataFirstObject> allList,alisttwo;
	@ViewInject(R.id.home_grid1)
	GridView home_grid1;
	@ViewInject(R.id.main_pull_refresh_view)
	PullToRefreshView mPullToRefreshView;
	int totalPage=1;
	boolean bool=false;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fgm_first_home,null);
		x.view().inject(this, view);
		homeImpl=new FgmHomeImpl();
		homeImpl.setViewFgm_FirstHome(this);
		homeImpl.sendFgmHomeAllData(Constants.SHOUYE_URL);

		mPullToRefreshView.setOnHeaderRefreshListener(this);
		mPullToRefreshView.setOnFooterRefreshListener(this);

		return view;
	}




	@Override
	public void showFirstdata(HomePager_data data) {
	String	check=data.getGetAdList().getStatus();

		if(check.equals("success")){
			/////顶部自动轮播
			vpTopList=data.getGetAdList().getData();
			topVpadapter=new FgmHomeTopVpAdapter(getActivity(),vpTopList);
			topViewPager.setAdapter(topVpadapter);
			runs=new myThread();
			handler.post(runs);
			changeVpOnClick();


			////////第一个gridview,第二个
			listTSGrid1=data.getGetTeSeShiChangGoods().getData();
			if(listTSGrid1 != null){
				setGridView(listTSGrid1);
			}

			//////上新
			showShangXinData(data);


		}
	}

	@Override
	public void showGridView(ArrayList<DataFirstObject> list) {
		Log.i("ttt",list+"aaa");
		allList.addAll(list);
		if(bool){
			alisttwo=allList;
			fgmHomeGrid3Adapter.setDataChange(alisttwo);
		}

	}


	private void showShangXinData(HomePager_data data){
		if(data != null){
			listTwo=data.getGetFirstThreeGoods().getData();
			home_goods1_tv1.setText(listTwo.get(0).getGoodsName());
			home_goods1_tv2.setText(listTwo.get(0).getTitle());
			home_goods2_tv1.setText(listTwo.get(1).getGoodsName());
			home_goods2_tv2.setText(listTwo.get(1).getTitle());
			home_goods3_tv1.setText(listTwo.get(2).getGoodsName());
			home_goods3_tv2.setText(listTwo.get(2).getTitle());
			home_goods5_tv1.setText(listTwo.get(1).getGoodsName());
			home_goods5_tv2.setText(listTwo.get(1).getTitle());
			home_goods6_tv1.setText(listTwo.get(2).getGoodsName());
			home_goods6_tv2.setText(listTwo.get(2).getTitle());
			home_goods4_tv1.setText("车内饰品");
			home_goods4_tv2.setText("新意");
			Glide.with(getActivity()).load(Constants.IMG_URL+listTwo.get(0).getGoodsPicList().get(0).getIcon()).into(home_goods1_iv);
			Glide.with(getActivity()).load(Constants.IMG_URL+listTwo.get(1).getGoodsPicList().get(0).getIcon()).placeholder(R.drawable.ic_launcher).into(home_goods2_iv);
			x.image().bind(home_goods3_iv,Constants.IMG_URL+listTwo.get(2).getGoodsPicList().get(0).getIcon());
			home_goods4_iv.setImageResource(R.mipmap.ic_launcher);
			////热卖榜
			Glide.with(getActivity()).load(Constants.IMG_URL+listTwo.get(0).getGoodsPicList().get(0).getIcon()).placeholder(R.drawable.ic_launcher).into(home_goods5_iv);
			x.image().bind(home_goods6_iv,Constants.IMG_URL+listTwo.get(1).getGoodsPicList().get(0).getIcon());

			//////折扣榜Left_listview
			listTBThree=data.getGetTaoBaoJieGoods().getData();
			fgmHomeListViewAdapter=new FgmHomeListViewAdapter(getActivity(),listTBThree);
			home_Listview.setAdapter(fgmHomeListViewAdapter);
			home_goods7_tv1.setText(listTBThree.get(0).getGoodsName());
			home_goods7_tv2.setText(listTBThree.get(0).getTitle());
			home_goods8_tv1.setText(listTBThree.get(4).getGoodsName());
			home_goods8_tv2.setText(listTBThree.get(4).getTitle());
			x.image().bind(home_goods7_iv,Constants.IMG_URL+listTBThree.get(0).getGoodsPicList().get(0).getIcon());
			x.image().bind(home_goods8_iv,Constants.IMG_URL+listTBThree.get(4).getGoodsPicList().get(0).getIcon());



			//////第三个gridview
			listFour=data.getGetRenQiGoods().getData();
			alisttwo=listFour;
			fgmHomeGrid3Adapter=new FgmHomeGrid3Adapter(getActivity(),alisttwo);
			customGridView2.setAdapter(fgmHomeGrid3Adapter);

		}
	}

	////设置gridview
	public void setGridView(ArrayList<DataFirstObject> listTSGrid1) {
		int columnWidth= SetColumnWidth.getColumnWidth(getActivity());/////获取屏幕宽度显示的个数
		int	gvWidth=columnWidth*listTSGrid1.size();/////获取到gridview的总宽度值
		LinearLayout.LayoutParams par=new LinearLayout.LayoutParams(gvWidth, LinearLayout.LayoutParams.MATCH_PARENT);
		//宽度                  匹配父类高度
		home_grid1.setLayoutParams(par);
		home_grid1.setColumnWidth(columnWidth);//每列的宽度，也就是Item的宽度
		home_grid1.setNumColumns(listTSGrid1.size());//GridView的列数
		fgmHomeGrid1Adapter=new FgmHomeGrid1Adapter(getActivity(),listTSGrid1);
		home_grid1.setAdapter(fgmHomeGrid1Adapter);

		///////第二个gridview
		fgmHomeGrid2Adapter=new FgmHomeGrid2Adapter(getActivity(),listTSGrid1);
		customGridView1.setAdapter(fgmHomeGrid2Adapter);


	}

	@Event(value = {R.id.home_tv_search},type = View.OnClickListener.class)
	private  void myOnClick(View view){
		switch (view.getId()){
			case R.id.home_tv_search:
				IsIntentUtils.toIntentActivity(getActivity(), Act_SearchClas.class);
			break;
		}
	}






	////上拉加载
	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {

			public void run() {
				totalPage++;
				if(totalPage>3){
					Toast.makeText(getActivity(), "已没有数据啦！", Toast.LENGTH_SHORT).show();
					mPullToRefreshView.onFooterRefreshComplete();

				}else{
					bool=true;
					homeImpl.sendGridView(Constants.SHOUYEFENYE_URL+totalPage);
					mPullToRefreshView.onFooterRefreshComplete();
				}

			}
		}, 1000);
	}

	////下拉刷新
	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {
			public void run() {
				mPullToRefreshView.onHeaderRefreshComplete();
			}
		}, 1000);
	}




	private class myThread implements Runnable{
		@Override
		public void run() {
			topViewPager.setCurrentItem(indexvp);
			indexvp++;
			if(indexvp == vpTopList.size()-1){
				indexvp=0;
			}
			handler.postDelayed(runs,2000);
		}

	}

	private void changeVpOnClick(){
		topViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

			@Override
			public void onPageSelected(int position) {
				indexvp=position;
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}


}
