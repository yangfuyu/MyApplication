package com.bc.mcapp.entity.usercar;
//查询某人的购物车数据
//http://localhost:8080/MeiChe/cart?cmd=queryCart&uid=1507b
public class UserCar_data {
private GetCarts getCarts;

public GetCarts getGetCarts() {
	return getCarts;
}

public void setGetCarts(GetCarts getCarts) {
	this.getCarts = getCarts;
}

@Override
public String toString() {
	return "UserCar_data [getCarts=" + getCarts + "]";
}

}
