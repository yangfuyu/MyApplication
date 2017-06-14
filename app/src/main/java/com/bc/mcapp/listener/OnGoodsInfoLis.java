package com.bc.mcapp.listener;

import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.detailgoods.GoodsInfo;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;

/**
 * Created by admins on 2016/10/20.
 */
public interface OnGoodsInfoLis {
    void onfenLeiToData(Conditions_data data);
    void onLikeQueryGoods(LikeQueryGoods_Data data);
    void onSingleGoodsInfo(DetailGoods_data data);
}
