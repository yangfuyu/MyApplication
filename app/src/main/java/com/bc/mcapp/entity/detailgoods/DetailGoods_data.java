package com.bc.mcapp.entity.detailgoods;
//商品的详情页
//http://localhost:8080/MeiChe/goods?cmd=getDetailGoods&goodsId=1
public class DetailGoods_data {
private GoodsInfo goodsInfo;
private Comment comment;



public GoodsInfo getGoodsInfo() {
	return goodsInfo;
}
public void setGoodsInfo(GoodsInfo goodsInfo) {
	this.goodsInfo = goodsInfo;
}
public Comment getComment() {
	return comment;
}
public void setComment(Comment comment) {
	this.comment = comment;
}
@Override
public String toString() {
	return "DetailGoods_data [goodsInfo=" + goodsInfo + ", comment=" + comment
			+ "]";
}

}
