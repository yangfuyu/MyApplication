package com.bc.mcapp.entity.order;

import java.util.ArrayList;

public class DataObject {
private Address address;
private String oid;
private ArrayList<OrderListObject> orderList;
private String otime;
private String payType;
private String sendType;
private String status;
private String totalMoney;



public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public ArrayList<OrderListObject> getOrderList() {
	return orderList;
}
public void setOrderList(ArrayList<OrderListObject> orderList) {
	this.orderList = orderList;
}
public String getOtime() {
	return otime;
}
public void setOtime(String otime) {
	this.otime = otime;
}
public String getPayType() {
	return payType;
}
public void setPayType(String payType) {
	this.payType = payType;
}
public String getSendType() {
	return sendType;
}
public void setSendType(String sendType) {
	this.sendType = sendType;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTotalMoney() {
	return totalMoney;
}
public void setTotalMoney(String totalMoney) {
	this.totalMoney = totalMoney;
}
@Override
public String toString() {
	return "DataObject [address=" + address + ", oid=" + oid + ", orderList="
			+ orderList + ", otime=" + otime + ", payType=" + payType
			+ ", sendType=" + sendType + ", status=" + status + ", totalMoney="
			+ totalMoney + "]";
}


}
