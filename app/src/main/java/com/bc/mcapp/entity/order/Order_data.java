package com.bc.mcapp.entity.order;
//根据条件查询订单
//http://localhost:8080/MeiChe/order?cmd=queryOrder&uid=1507b&orderType=0
import java.util.ArrayList;

public class Order_data {
private String cmd;
private ArrayList<DataObject> data;
private String status;



public String getCmd() {
	return cmd;
}
public void setCmd(String cmd) {
	this.cmd = cmd;
}
public ArrayList<DataObject> getData() {
	return data;
}
public void setData(ArrayList<DataObject> data) {
	this.data = data;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Order_data [cmd=" + cmd + ", data=" + data + ", status=" + status
			+ "]";
}

}
