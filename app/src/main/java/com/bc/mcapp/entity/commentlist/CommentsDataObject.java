package com.bc.mcapp.entity.commentlist;

import java.util.ArrayList;

public class CommentsDataObject {
private String cid;
private String content;
private ArrayList<CommentsPicsObject> pics;
private String time;
private String xingCount;
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public ArrayList<CommentsPicsObject> getPics() {
	return pics;
}
public void setPics(ArrayList<CommentsPicsObject> pics) {
	this.pics = pics;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getXingCount() {
	return xingCount;
}
public void setXingCount(String xingCount) {
	this.xingCount = xingCount;
}
@Override
public String toString() {
	return "CommentsDataObject [cid=" + cid + ", content=" + content
			+ ", pics=" + pics + ", time=" + time + ", xingCount=" + xingCount
			+ "]";
}

}
