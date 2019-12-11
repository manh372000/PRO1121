package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.Truyen.TruyenTranh;
import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.api.ApiLayTruyen;

import java.util.ArrayList;

public class DocTruyenActivity extends AppCompatActivity {
ImageView imgAnh;
ArrayList<String> arrUrlAnh;
int soTrang,soTrangDangDoc;
TextView txvSoTrang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        init();
        anhXa();
        setUp();
        setClick();

    }
    private void init(){
        arrUrlAnh = new ArrayList<>();
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/001.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/003.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/004.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/004.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/005.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/005.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/006.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/007.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/008.jpg");
        arrUrlAnh.add("http://imageinstant.com/data/images/24604/509435/009.jpg");
        soTrangDangDoc =1;
        soTrang=arrUrlAnh.size();
    }
    private void anhXa(){
        imgAnh =findViewById(R.id.imgAnh);
        txvSoTrang =findViewById(R.id.txvSoTrang);

    }
    private void setUp(){
        docTheoTrang(0);


    }
    private void setClick(){


    }
    public void right(View view) {
        docTheoTrang(1);
    }

    public void left(View view) {
        docTheoTrang(-1);
    }

    private void docTheoTrang(int i){
        soTrangDangDoc= soTrangDangDoc+i;
        if (soTrangDangDoc==0){
            soTrangDangDoc=1;
        }
        if(soTrangDangDoc>soTrang){
            soTrangDangDoc = soTrang;
        }
        txvSoTrang.setText(soTrangDangDoc+" / "+soTrang);
        Glide.with(this).load(arrUrlAnh.get(soTrangDangDoc-1)).into(imgAnh);

    }
}
