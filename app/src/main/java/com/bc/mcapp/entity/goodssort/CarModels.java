package com.bc.mcapp.entity.goodssort;

import java.util.ArrayList;

public class CarModels {
private String status;
private ArrayList<CarDataObject> data;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<CarDataObject> getData() {
	return data;
}
public void setData(ArrayList<CarDataObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "CarModels [status=" + status + ", data=" + data + "]";
}

}
