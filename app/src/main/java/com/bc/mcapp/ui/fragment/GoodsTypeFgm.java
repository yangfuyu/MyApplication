package com.bc.mcapp.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.ui.activity.GoodsInfoActivity;
import com.bc.mcapp.ui.adapter.GoodsTypeRcylAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.DividerGridItemDecoration;
import com.bc.mcapp.view.GoodsInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by admins on 2016/10/21.
 */
public class GoodsTypeFgm extends Fragment implements GoodsInfo {
    GoodsInfoPreImpl goodsInfoPreImpl;
    View view;
    GoodsTypeRcylAdapter adapter;
    GridLayoutManager gridManager;
    @ViewInject(R.id.fgm_gods_RcylView1)
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fgm_gods_type_lin,null,false);
        x.view().inject(this, view);
        goodsInfoPreImpl=new GoodsInfoPreImpl();
        goodsInfoPreImpl.setGoodsInfo(this);
        gridManager=new GridLayoutManager(getActivity(),1);
        rv.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(((GoodsInfoActivity)getActivity()).index != null){
            String idex=((GoodsInfoActivity)getActivity()).index;
            goodsInfoPreImpl.goodsTypePre(Constants.GOODSTYPE_URL+idex);
        }


        return view;
    }



    @Override
    public void showGoodsTypeData(Conditions_data data) {
        if(data != null){
            adapter=new GoodsTypeRcylAdapter(getActivity(),data);
            rv.setAdapter(adapter);
        }

    }

    @Override
    public void showLikeQueryGooods(LikeQueryGoods_Data data) {

    }

    @Override
    public void showSingleGoodsInfo(DetailGoods_data data) {

    }


}
