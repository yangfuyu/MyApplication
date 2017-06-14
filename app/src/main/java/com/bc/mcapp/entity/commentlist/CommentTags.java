package com.bc.mcapp.entity.commentlist;

import java.util.ArrayList;

public class CommentTags {
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
	return "CommentTags [status=" + status + ", data=" + data + "]";
}


}
