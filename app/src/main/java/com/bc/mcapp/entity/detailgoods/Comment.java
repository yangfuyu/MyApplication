package com.bc.mcapp.entity.detailgoods;

public class Comment {
private String goodCommentRate;
private String totalCommentCount;
private Data data;


public String getGoodCommentRate() {
	return goodCommentRate;
}
public void setGoodCommentRate(String goodCommentRate) {
	this.goodCommentRate = goodCommentRate;
}
public String getTotalCommentCount() {
	return totalCommentCount;
}
public void setTotalCommentCount(String totalCommentCount) {
	this.totalCommentCount = totalCommentCount;
}
public Data getData() {
	return data;
}
public void setData(Data data) {
	this.data = data;
}
@Override
public String toString() {
	return "Comment [goodCommentRate=" + goodCommentRate
			+ ", totalCommentCount=" + totalCommentCount + ", data=" + data
			+ "]";
}

}
