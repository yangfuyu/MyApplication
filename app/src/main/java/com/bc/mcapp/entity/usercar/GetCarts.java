package com.bc.mcapp.entity.usercar;

import java.util.ArrayList;

public class GetCarts {
private String status;
private ArrayList<DataObject> data;


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
	return "GetCarts [status=" + status + ", data=" + data + "]";
}


}
