package com.bc.mcapp.entity.homepager;

import java.util.ArrayList;

public class DataFirstObject {
private String currentNum;
private String giveScore;
private String goodsId;
private String goodsName;
private ArrayList<GoodsPicListObject> goodsPicList;
private String newPrice;
private String oldPrice;
private String sellNum0;
private String title;


public String getCurrentNum() {
	return currentNum;
}
public void setCurrentNum(String currentNum) {
	this.currentNum = currentNum;
}
public String getGiveScore() {
	return giveScore;
}
public void setGiveScore(String giveScore) {
	this.giveScore = giveScore;
}
public String getGoodsId() {
	return goodsId;
}
public void setGoodsId(String goodsId) {
	this.goodsId = goodsId;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public ArrayList<GoodsPicListObject> getGoodsPicList() {
	return goodsPicList;
}
public void setGoodsPicList(ArrayList<GoodsPicListObject> goodsPicList) {
	this.goodsPicList = goodsPicList;
}
public String getNewPrice() {
	return newPrice;
}
public void setNewPrice(String newPrice) {
	this.newPrice = newPrice;
}
public String getOldPrice() {
	return oldPrice;
}
public void setOldPrice(String oldPrice) {
	this.oldPrice = oldPrice;
}
public String getSellNum0() {
	return sellNum0;
}
public void setSellNum0(String sellNum0) {
	this.sellNum0 = sellNum0;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "DataFirstObject [currentNum=" + currentNum + ", giveScore="
			+ giveScore + ", goodsId=" + goodsId + ", goodsName=" + goodsName
			+ ", goodsPicList=" + goodsPicList + ", newPrice=" + newPrice
			+ ", oldPrice=" + oldPrice + ", sellNum0=" + sellNum0 + ", title="
			+ title + "]";
}


}
