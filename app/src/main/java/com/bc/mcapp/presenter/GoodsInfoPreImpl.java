package com.bc.mcapp.presenter;

import android.util.Log;

import com.bc.mcapp.biz.GoodsInfoBizImpl;
import com.bc.mcapp.biz.bizinterface.GoodsInfoBiz;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.goodssort.Goods;
import com.bc.mcapp.entity.goodssort.GoodsSort_data;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.listener.OnGoodsInfoLis;
import com.bc.mcapp.presenter.preinterface.GoodsInfoPre;
import com.bc.mcapp.view.GoodsInfo;

/**
 * Created by admins on 2016/10/20.
 */
public class GoodsInfoPreImpl implements GoodsInfoPre ,OnGoodsInfoLis{
    private GoodsInfo goodsInfo;
    private GoodsInfoBiz goodsInfoBiz;

    public GoodsInfoPreImpl(){
        goodsInfoBiz=new GoodsInfoBizImpl(this);
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public void goodsTypePre(String url) {
        goodsInfoBiz.getFenLeiAllUrl(url);
    }

    @Override
    public void likeQueryGoods(String url) {
        goodsInfoBiz.getLikeQueryGoods(url);
    }

    @Override
    public void singleGoodsInfo(String url) {
        goodsInfoBiz.getSingleGoodsInfo(url);
    }


    @Override
    public void onfenLeiToData(Conditions_data data) {
        goodsInfo.showGoodsTypeData(data);
    }

    @Override
    public void onLikeQueryGoods(LikeQueryGoods_Data data) {
        goodsInfo.showLikeQueryGooods(data);
    }

    @Override
    public void onSingleGoodsInfo(DetailGoods_data data) {
        goodsInfo.showSingleGoodsInfo(data);
    }


}
