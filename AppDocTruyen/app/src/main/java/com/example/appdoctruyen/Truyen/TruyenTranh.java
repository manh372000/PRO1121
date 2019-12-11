package com.example.appdoctruyen.Truyen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.jar.JarException;

public class TruyenTranh implements Serializable {
    private String tenTruyen, tenChap,LinkAnh;
    /*
    {
    "tenTruyen":",
    "tenChap":",
    "LinkAnh":"


    }
     */

    public  TruyenTranh(){

    }
    public TruyenTranh(JSONObject o)throws JSONException{
        tenTruyen = o.getString("tenTruyen");
        tenChap = o.getString("tenChap");
        LinkAnh = o.getString("LinkAnh");


    }
    public TruyenTranh(String tenTruyen, String tenChap, String linkAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        LinkAnh = linkAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        LinkAnh = linkAnh;
    }
}
