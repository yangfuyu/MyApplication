package com.bc.mcapp.entity.goodssort;

public class FlowerDataObject {
private String fid;
private String fname;
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
@Override
public String toString() {
	return "FlowerDataObject [fid=" + fid + ", fname=" + fname + "]";
}

}
