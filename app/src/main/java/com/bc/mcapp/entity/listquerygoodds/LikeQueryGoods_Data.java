package com.bc.mcapp.entity.listquerygoodds;

import java.util.ArrayList;

/**
 * Created by admins on 2016/10/31.
 */
public class LikeQueryGoods_Data {
    private String cmd;
    private String status;
    private ArrayList<QueryData> data;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<QueryData> getData() {
        return data;
    }

    public void setData(ArrayList<QueryData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LikeQueryGoods_Data{" +
                "cmd='" + cmd + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
