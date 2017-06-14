package com.bc.mcapp.entity.homepager;

import java.util.ArrayList;

public class GetTaoBaoJieGoodsObject {
private String status;
private ArrayList<DataFirstObject> data;



public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<DataFirstObject> getData() {
	return data;
}
public void setData(ArrayList<DataFirstObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "GetTaoBaoJieGoodsObject [status=" + status + ", data=" + data + "]";
}

}
