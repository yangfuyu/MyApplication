package com.bc.mcapp.entity.useraddress;

public class DataObject {
private String address;
private String aid;
private String code;
private String phone;
private String telephone;
private String uid;
private String uname;


public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAid() {
	return aid;
}
public void setAid(String aid) {
	this.aid = aid;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
@Override
public String toString() {
	return "DataObject [address=" + address + ", aid=" + aid + ", code=" + code
			+ ", phone=" + phone + ", telephone=" + telephone + ", uid=" + uid
			+ ", uname=" + uname + "]";
}


}
