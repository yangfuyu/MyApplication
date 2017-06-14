package com.bc.mcapp.entity.goodssort;

import java.util.ArrayList;

public class FlowerList {
private String status;
private ArrayList<FlowerDataObject> data;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<FlowerDataObject> getData() {
	return data;
}
public void setData(ArrayList<FlowerDataObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "FlowerList [status=" + status + ", data=" + data + "]";
}


}
