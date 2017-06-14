package com.bc.mcapp.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.ui.activity.GoodsInfoActivity;
import com.bc.mcapp.ui.adapter.GoodsMyAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.DividerItemDecoration;
import com.bc.mcapp.view.GoodsInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by admins on 2016/10/21.
 */
public class GoodsXiaoLiangFgm extends Fragment implements GoodsInfo{
    @ViewInject(R.id.fgm_gods_RcylView2)
    RecyclerView fgm_gods_RcylView2;
    View view;
    GoodsMyAdapter adapter;
    LinearLayoutManager linMan;
    GoodsInfoPreImpl goodsInfoPreImpl;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fgm_gods_xiaoliang_lin,null);
        x.view().inject(this, view);
        goodsInfoPreImpl=new GoodsInfoPreImpl();
        goodsInfoPreImpl.setGoodsInfo(this);
        linMan=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,true);
        fgm_gods_RcylView2.addItemDecoration(new DividerItemDecoration(getActivity(),1));
        fgm_gods_RcylView2.setLayoutManager(linMan);


        if( ((GoodsInfoActivity)getActivity()).sendDataBoolean){
                boolean bol=((GoodsInfoActivity)getActivity()).sendDataBoolean;
                goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+bol);
        }else{
            goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+false);
        }


        return view;
    }

    @Override
    public void showGoodsTypeData(Conditions_data data) {
        if(data != null){
            adapter=new GoodsMyAdapter(getActivity(),data);
            fgm_gods_RcylView2.setAdapter(adapter);
        }
    }

    @Override
    public void showLikeQueryGooods(LikeQueryGoods_Data data) {

    }

    @Override
    public void showSingleGoodsInfo(DetailGoods_data data) {

    }


}
