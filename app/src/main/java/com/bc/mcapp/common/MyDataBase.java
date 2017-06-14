package com.bc.mcapp.common;

import com.bc.mcapp.R;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by admins on 2016/10/31.
 */
@Table(name="mydatabase")
public class MyDataBase {
    @Column(name = "id")
    private int id;
    @Column(name = "goodsname")
    private String  goodsname;
    @Column(name = "goodsid")
    private String goodsid;

    public MyDataBase() {
    }

    public MyDataBase(String  goodsname, String goodsid){
        this.goodsname=goodsname;
        this.goodsid=goodsid;
    }
    public MyDataBase(int id,String  goodsname, String goodsid){
        this.id=id;
        this.goodsname=goodsname;
        this.goodsid=goodsid;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }
}
