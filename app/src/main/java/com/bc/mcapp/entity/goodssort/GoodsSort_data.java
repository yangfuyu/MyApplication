package com.bc.mcapp.entity.goodssort;

import java.util.ArrayList;

//选择分类
//http://localhost:8080/MeiChe/goods?cmd=getGoodsFenLei&goodsId=1
public class GoodsSort_data {
private ArrayList<Goods>  goods;
private ColorList colorList;
private FlowerList flowerList;
private CarModels carModels;


public ArrayList<Goods> getGoods() {
	return goods;
}
public void setGoods(ArrayList<Goods> goods) {
	this.goods = goods;
}
public ColorList getColorList() {
	return colorList;
}
public void setColorList(ColorList colorList) {
	this.colorList = colorList;
}
public FlowerList getFlowerList() {
	return flowerList;
}
public void setFlowerList(FlowerList flowerList) {
	this.flowerList = flowerList;
}
public CarModels getCarModels() {
	return carModels;
}
public void setCarModels(CarModels carModels) {
	this.carModels = carModels;
}
@Override
public String toString() {
	return "GoodsSort_data [goods=" + goods + ", colorList=" + colorList
			+ ", flowerList=" + flowerList + ", carModels=" + carModels + "]";
}

}
