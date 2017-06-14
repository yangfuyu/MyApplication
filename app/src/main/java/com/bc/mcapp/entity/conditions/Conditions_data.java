package com.bc.mcapp.entity.conditions;
//按商品条件进行查询的商品数据
//http://localhost:8080/MeiChe/goodsType?cmd=getGoodsByConditions&id=1
import java.util.ArrayList;

public class Conditions_data {
private String cmd;
private String status;
private ArrayList<DataObject> data;


public String getCmd() {
	return cmd;
}
public void setCmd(String cmd) {
	this.cmd = cmd;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<DataObject> getData() {
	return data;
}
public void setData(ArrayList<DataObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "Conditions_data [cmd=" + cmd + ", status=" + status + ", data="
			+ data + "]";
}

}
