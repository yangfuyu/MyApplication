package com.bc.mcapp.utils;

public interface Constants {
	
	String IP="192.168.23.113";
	//首页地址
	String SHOUYE_URL="http://"+IP+":8080/MeiChe/goods?cmd=getIndexData";
	/////首页分页
	String SHOUYEFENYE_URL="http://"+IP+":8080/MeiChe/goods?cmd=getRenQiGoods&page=";
	//////图片拼接地址
	String IMG_URL="http://"+IP+":8080/MeiChe/";
	//////商品详情
	String GOODSINFO_URL="http://"+IP+":8080/MeiChe/goods?cmd=getDetailGoods&goodsId=";

	String BUYCAR_URL="http://"+IP+":8080/MeiChe/cart?cmd=queryCart&uid=";
	//////商品分类查询
	String GOODSTP_URLALL="http://"+IP+":8080/MeiChe/goodsType?cmd=getGoodsByConditions";
	//////分类页
	String GOODSTYPE_URL="http://"+IP+":8080/MeiChe/goodsType?cmd=getGoodsByConditions&typeId=";
	/////添加用户
	String ADDUSERINFO_URL="http://"+IP+":8080/MeiChe/user?cmd=addUser&";
	////手机号验证
	String USERLOGINPHONE_URL="http://"+IP+":8080/MeiChe/user?loginId=";
	/////登录
	String USERLOGIN_URL="http://"+IP+":8080/MeiChe/user?cmd=login&";
	//////更新用户名
	String UPDATENAME_URL="http://"+IP+":8080/MeiChe/user?cmd=update&type=";

	////添加商品到某人购物车
	String INSERTGOODS_USERCART_URL="http://"+IP+":8080/MeiChe/cart?cmd=addToCart&uid=";///"&goodsId="+num+"&orderNum=";

	/////查询某人的购物车信息
	String QUERYUSERCAR_URL="http://"+IP+":8080/MeiChe/cart?cmd=queryCart&uid=";

	/////搜索页 模糊查询
	String LIKEQUERY_URL="http://"+IP+":8080/MeiChe/goods?cmd=getGoodsList&name=";

	////更新某人购物车信息
	String UPDATECARTINFO="http://"+IP+":8080/MeiChe/cart?cmd=updateCart&uid=123&goodsId=";//&orderNum=";

	////添加订单
	String INSERTORDER_URL="http://"+IP+":8080/MeiChe/order?cmd=addOrder&uid=";////+1+"&addressId=1&totalMoney="+2+"&sendtype=abc&payType=bcd&detailList=";

	/////删除订单 数据库改all
	String DELETEORDER_URL="http://"+IP+":8080/MeiChe/order?cmd=deleteOrder";

	////查询 0;//买家未付款     1;//买家已经付款    2;//已经取消
	String QUERY_NOPAY_ORDER="http://"+IP+":8080/MeiChe/order?cmd=queryOrder&uid="; ///"&orderType=0";

	////2&loginId=1507b&value='images/pic1.png'
	/**
	 * 更新用户信息
	 * type:
	 *   1:更新头像
	 *   2:更新用户名
	 *   3:更新性别
	 *   4:更新密码
	 *   5:更新生日
	 *   6:更新积分
	 *
	 *   if(type==1){
	 str.append(" icon='"+value+"' ");
	 }else if(type==2){
	 str.append(" username='"+value+"'");
	 }else if(type==3){
	 str.append(" sex=").append(value);
	 }else if(type==4){
	 str.append(" loginPwd='"+value+"'");
	 }else if(type==5){
	 str.append(" birthday='"+value+"'");
	 }else if(type==6){
	 str.append(" score=").append(value);

	 修改密码
	 * http://localhost:8080/MeiChe/user?cmd=update&loginId=abc&value=4321
	 */

}
