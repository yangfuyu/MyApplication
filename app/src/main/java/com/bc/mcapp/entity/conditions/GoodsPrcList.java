package com.bc.mcapp.entity.conditions;

public class GoodsPrcList {
private String icon;
private String pid;

public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
@Override
public String toString() {
	return "GoodsPrcList [icon=" + icon + ", pid=" + pid + "]";
}

}
