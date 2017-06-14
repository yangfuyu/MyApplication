package com.bc.mcapp.entity.commentlist;

public class DataObject {
private String count;
private String tagName;
private String tid;
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public String getTagName() {
	return tagName;
}
public void setTagName(String tagName) {
	this.tagName = tagName;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "DataObject [count=" + count + ", tagName=" + tagName + ", tid="
			+ tid + "]";
}

}
