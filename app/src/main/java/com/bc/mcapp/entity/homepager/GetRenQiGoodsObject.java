package com.bc.mcapp.entity.homepager;

import java.util.ArrayList;

public class GetRenQiGoodsObject {

private String status;
private String totalPage;
private String nowPage;
private ArrayList<DataFirstObject> data;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	public ArrayList<DataFirstObject> getData() {
		return data;
	}

	public void setData(ArrayList<DataFirstObject> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GetRenQiGoodsObject{" +
				"status='" + status + '\'' +
				", totalPage='" + totalPage + '\'' +
				", nowPage='" + nowPage + '\'' +
				", data=" + data +
				'}';
	}
}
