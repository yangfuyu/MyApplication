package com.bc.mcapp.entity.order;

public class OrderListObject {
private String did;
private Goods goods;
private String onum;



public String getDid() {
	return did;
}
public void setDid(String did) {
	this.did = did;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
public String getOnum() {
	return onum;
}
public void setOnum(String onum) {
	this.onum = onum;
}
@Override
public String toString() {
	return "OrderListObject [did=" + did + ", goods=" + goods + ", onum="
			+ onum + "]";
}
public OrderListObject() {
	super();
	// TODO Auto-generated constructor stub
}


}
