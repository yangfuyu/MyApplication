package com.bc.mcapp.entity.goodssort;

public class CarDataObject {
private String cmId;
private String cmName;


public String getCmId() {
	return cmId;
}
public void setCmId(String cmId) {
	this.cmId = cmId;
}
public String getCmName() {
	return cmName;
}
public void setCmName(String cmName) {
	this.cmName = cmName;
}
@Override
public String toString() {
	return "CarDataObject [cmId=" + cmId + ", cmName=" + cmName + "]";
}

}
