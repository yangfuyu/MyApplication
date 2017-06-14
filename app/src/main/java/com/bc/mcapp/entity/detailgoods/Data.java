package com.bc.mcapp.entity.detailgoods;

import java.util.ArrayList;

public class Data {
private String content;
private String time;
private ArrayList<PicsObject> pics;
private String xingCount;
private String cid;




public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public ArrayList<PicsObject> getPics() {
	return pics;
}
public void setPics(ArrayList<PicsObject> pics) {
	this.pics = pics;
}
public String getXingCount() {
	return xingCount;
}
public void setXingCount(String xingCount) {
	this.xingCount = xingCount;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
@Override
public String toString() {
	return "Data [content=" + content + ", time=" + time + ", pics=" + pics
			+ ", xingCount=" + xingCount + ", cid=" + cid + "]";
}

}
