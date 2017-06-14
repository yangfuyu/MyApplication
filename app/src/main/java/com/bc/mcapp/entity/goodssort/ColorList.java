package com.bc.mcapp.entity.goodssort;

import java.util.ArrayList;

public class ColorList {
private String status;
private ArrayList<ColorDataObject> data;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<ColorDataObject> getData() {
	return data;
}
public void setData(ArrayList<ColorDataObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "ColorList [status=" + status + ", data=" + data + "]";
}

}
