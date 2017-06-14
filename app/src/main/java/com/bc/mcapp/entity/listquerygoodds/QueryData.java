package com.bc.mcapp.entity.listquerygoodds;

/**
 * Created by admins on 2016/10/31.
 */
public class QueryData {
    private String oldPrice;
    private String goodsId;
    private String newPrice;
    private String currentNum;
    private String title;
    private String sellNum;
    private String giveScore;
    private String goodsName;

    @Override
    public String toString() {
        return "QueryData{" +
                "oldPrice='" + oldPrice + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", currentNum='" + currentNum + '\'' +
                ", title='" + title + '\'' +
                ", sellNum='" + sellNum + '\'' +
                ", giveScore='" + giveScore + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(String currentNum) {
        this.currentNum = currentNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getGiveScore() {
        return giveScore;
    }

    public void setGiveScore(String giveScore) {
        this.giveScore = giveScore;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
