package com.bc.mcapp.entity.homepager;

public class DataObject {
private String adIcon;
private String aid;




public String getAdIcon() {
	return adIcon;
}
public void setAdIcon(String adIcon) {
	this.adIcon = adIcon;
}
public String getAid() {
	return aid;
}
public void setAid(String aid) {
	this.aid = aid;
}
@Override
public String toString() {
	return "DataObject [adIcon=" + adIcon + ", aid=" + aid + "]";
}

}
