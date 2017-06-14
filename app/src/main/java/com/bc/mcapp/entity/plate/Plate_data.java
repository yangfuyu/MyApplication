package com.bc.mcapp.entity.plate;
//上屏的模块列表
//http://localhost:8080/MeiChe/plate
import java.util.ArrayList;

public class Plate_data {
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
	return "Plate_data [cmd=" + cmd + ", status=" + status + ", data=" + data
			+ "]";
}

}
