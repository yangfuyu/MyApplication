package com.bc.mcapp.entity.plate;

public class DataObject {
private String pid;
private String pname;
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
@Override
public String toString() {
	return "DataObject [pid=" + pid + ", pname=" + pname + "]";
}

}
