package com.bc.mcapp.entity.usercar;

public class DataObject {
private String cid;
private Goods goods;
private String orderNum;
private String time;



public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
public String getOrderNum() {
	return orderNum;
}
public void setOrderNum(String orderNum) {
	this.orderNum = orderNum;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "DataObject [cid=" + cid + ", goods=" + goods + ", orderNum="
			+ orderNum + ", time=" + time + "]";
}

}
