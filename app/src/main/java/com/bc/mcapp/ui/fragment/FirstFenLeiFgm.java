package com.bc.mcapp.ui.fragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.common.CustomGridView;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.goodssort.Goods;
import com.bc.mcapp.entity.goodssort.GoodsPicListObject;
import com.bc.mcapp.entity.goodssort.GoodsSort_data;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.ui.activity.GoodsInfoActivity;
import com.bc.mcapp.ui.adapter.CustomFenLeiGvAdapter;
import com.bc.mcapp.ui.adapter.CustomFenleiLvAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.GoodsInfo;

import java.util.ArrayList;

public class FirstFenLeiFgm extends Fragment implements GoodsInfo{
	View view;
	CustomFenleiLvAdapter fLAdapter;
	@ViewInject(R.id.fgm_fenlei_leftList)
	ListView fLListView;
	CustomFenLeiGvAdapter adapter;
	@ViewInject(R.id.fgm_fenlei_subGridView)
	CustomGridView fgm_fenlei_subGridView;
	GoodsInfoPreImpl goodsInfoPreImpl;
	@ViewInject(R.id.fgm_fenlei_topIv)
	ImageView fgm_fenlei_topIv;
	int isFirst=0;
	int ss;
	Conditions_data da;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fgm_first_fenlei,null);
		x.view().inject(this, view);
		goodsInfoPreImpl=new GoodsInfoPreImpl();
		goodsInfoPreImpl.setGoodsInfo(this);

		if(isFirst == 0){
			int i=1;
			goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+i);
		}


		setListViewData();
		
		return view;
	}

	private void setListViewData(){
		 String[] arrayList = new String[] { "推荐分类","坐垫装饰","洗刷用品","保护系列","GPS导航",
				"金属支架","行车记录","钥匙环扣","豪车车标","改装零件","车内饰品","汽车旅行",
				"车旅行架","车旅行箱","车内冰箱","汽车投影"};
		fLAdapter=new CustomFenleiLvAdapter(getActivity(),arrayList);
		fLListView.setAdapter(fLAdapter);
	}


	@Override
	public void showGoodsTypeData(Conditions_data data) {
		if (data != null) {
			if(isFirst == 0){
				x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+data.getData().get(1).getGoodsPicList().get(0).getIcon());
				isFirst=200;
			}

			adapter=new CustomFenLeiGvAdapter(getActivity(),data);
			da=data;
			fLListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					ss=position;
					if(ss == 0){
						x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+da.getData().get(ss).getGoodsPicList().get(0).getIcon());
						goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+1);
						adapter=new CustomFenLeiGvAdapter(getActivity(),da);

					}else if(ss == 1){
						x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+da.getData().get(ss).getGoodsPicList().get(0).getIcon());
						goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+2);
						adapter=new CustomFenLeiGvAdapter(getActivity(),da);
					}else if(ss == 2){
						x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+da.getData().get(1).getGoodsPicList().get(0).getIcon());
						goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+3);
						adapter=new CustomFenLeiGvAdapter(getActivity(),da);
					}else if(ss >2){
						int as=ss%2;
						if(as == 0){
							x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+da.getData().get(0).getGoodsPicList().get(0).getIcon());
							goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+1);
							adapter=new CustomFenLeiGvAdapter(getActivity(),da);
						}else{
							x.image().bind(fgm_fenlei_topIv, Constants.IMG_URL+da.getData().get(1).getGoodsPicList().get(0).getIcon());
							goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+2);
							adapter=new CustomFenLeiGvAdapter(getActivity(),da);
						}

					}
				}
			});
		}
			fgm_fenlei_subGridView.setAdapter(adapter);


		fgm_fenlei_subGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
				int po=position;
				Intent intent=new Intent(getActivity(),GoodsInfoActivity.class);
				if(position == 0){
					intent.putExtra("goodsId",1+"");
				}else if(position == 1){
					intent.putExtra("goodsId",2+"");
				}else if(position == 2){
					intent.putExtra("goodsId",3+"");
				}else if(position >2){
					int ispo=po%2;
					if(ispo == 0){
						intent.putExtra("goodsId",1+"");
					}else{
						intent.putExtra("goodsId",2+"");
					}
				}
				intent.putExtra("goodsBool",true);
				startActivity(intent);
			}
		});
		}

	@Override
	public void showLikeQueryGooods(LikeQueryGoods_Data data) {}

	@Override
	public void showSingleGoodsInfo(DetailGoods_data data) {

	}


}
