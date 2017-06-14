package com.bc.mcapp.entity.commentlist;

import java.util.ArrayList;

public class Comments {
private String status;
private ArrayList<CommentsDataObject> data;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<CommentsDataObject> getData() {
	return data;
}
public void setData(ArrayList<CommentsDataObject> data) {
	this.data = data;
}
@Override
public String toString() {
	return "Comments [status=" + status + ", data=" + data + "]";
}

}
