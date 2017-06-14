package com.bc.mcapp.entity.collect;

import com.bc.mcapp.entity.usercar.Goods;

public class DataObject {
private String cid;
private Goods goods;
private String time;


public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "DataObject [cid=" + cid + ", goods=" + goods + ", time=" + time
			+ "]";
}

}
