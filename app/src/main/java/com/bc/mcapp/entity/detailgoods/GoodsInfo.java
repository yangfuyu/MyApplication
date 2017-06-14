package com.bc.mcapp.entity.detailgoods;

import java.util.ArrayList;

public class GoodsInfo {
private String oldPrice;
private String goodsId;
private String newPrice;
private ArrayList<GoodsPicListObject> goodsPicList;
private String currentNum;
private String title;
private String sellNum;
private String goodsDesc;
private String giveScore;
private String goodsName;




public String getOldPrice() {
	return oldPrice;
}
public void setOldPrice(String oldPrice) {
	this.oldPrice = oldPrice;
}
public String getGoodsId() {
	return goodsId;
}
public void setGoodsId(String goodsId) {
	this.goodsId = goodsId;
}
public String getNewPrice() {
	return newPrice;
}
public void setNewPrice(String newPrice) {
	this.newPrice = newPrice;
}
public ArrayList<GoodsPicListObject> getGoodsPicList() {
	return goodsPicList;
}
public void setGoodsPicList(ArrayList<GoodsPicListObject> goodsPicList) {
	this.goodsPicList = goodsPicList;
}
public String getCurrentNum() {
	return currentNum;
}
public void setCurrentNum(String currentNum) {
	this.currentNum = currentNum;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSellNum() {
	return sellNum;
}
public void setSellNum(String sellNum) {
	this.sellNum = sellNum;
}
public String getGoodsDesc() {
	return goodsDesc;
}
public void setGoodsDesc(String goodsDesc) {
	this.goodsDesc = goodsDesc;
}
public String getGiveScore() {
	return giveScore;
}
public void setGiveScore(String giveScore) {
	this.giveScore = giveScore;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
@Override
public String toString() {
	return "GoodsInfo [oldPrice=" + oldPrice + ", goodsId=" + goodsId
			+ ", newPrice=" + newPrice + ", goodsPicList=" + goodsPicList
			+ ", currentNum=" + currentNum + ", title=" + title + ", sellNum="
			+ sellNum + ", goodsDesc=" + goodsDesc + ", giveScore=" + giveScore
			+ ", goodsName=" + goodsName + "]";
}

}
