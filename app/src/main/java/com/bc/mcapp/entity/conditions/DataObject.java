package com.bc.mcapp.entity.conditions;

import java.util.ArrayList;

public class DataObject {
private String oldPrice;
private String goodsId;
private String newPrice;
private ArrayList<GoodsPrcList> goodsPicList;
private String currentNum;
private String sellNum;
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
public ArrayList<GoodsPrcList> getGoodsPicList() {
	return goodsPicList;
}
public void setGoodsPicList(ArrayList<GoodsPrcList> goodsPicList) {
	this.goodsPicList = goodsPicList;
}
public String getCurrentNum() {
	return currentNum;
}
public void setCurrentNum(String currentNum) {
	this.currentNum = currentNum;
}
public String getSellNum() {
	return sellNum;
}
public void setSellNum(String sellNum) {
	this.sellNum = sellNum;
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
	return "DataObject [oldPrice=" + oldPrice + ", goodsId=" + goodsId
			+ ", newPrice=" + newPrice + ", goodsPicList=" + goodsPicList
			+ ", currentNum=" + currentNum + ", sellNum=" + sellNum
			+ ", giveScore=" + giveScore + ", goodsName=" + goodsName + "]";
}

}
