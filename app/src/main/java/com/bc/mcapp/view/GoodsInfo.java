package com.bc.mcapp.view;

import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.goodssort.Goods;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;

/**
 * Created by admins on 2016/10/20.
 */
public interface GoodsInfo {
    void showGoodsTypeData(Conditions_data data);
    void showLikeQueryGooods(LikeQueryGoods_Data data);
    void showSingleGoodsInfo(DetailGoods_data data);

}
