package com.bc.mcapp.entity.usercar;

import java.util.ArrayList;

public class Goods {
private String currentNum;
private String giveScore;
private String goodsDesc;
private String goodsId;
private String goodsName;
private ArrayList<GoodsPicListObject> goodsPicList;
private String newPrice;
private String oldPrice;
private String sellNum;
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
public String getGoodsDesc() {
	return goodsDesc;
}
public void setGoodsDesc(String goodsDesc) {
	this.goodsDesc = goodsDesc;
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
public String getSellNum() {
	return sellNum;
}
public void setSellNum(String sellNum) {
	this.sellNum = sellNum;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "Goods [currentNum=" + currentNum + ", giveScore=" + giveScore
			+ ", goodsDesc=" + goodsDesc + ", goodsId=" + goodsId
			+ ", goodsName=" + goodsName + ", goodsPicList=" + goodsPicList
			+ ", newPrice=" + newPrice + ", oldPrice=" + oldPrice
			+ ", sellNum=" + sellNum + ", title=" + title + "]";
}

}
