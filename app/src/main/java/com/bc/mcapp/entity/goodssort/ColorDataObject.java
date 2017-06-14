package com.bc.mcapp.entity.goodssort;

public class ColorDataObject {
private String cid;
private String cname;
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "ColorDataObject [cid=" + cid + ", cname=" + cname + "]";
}

}
