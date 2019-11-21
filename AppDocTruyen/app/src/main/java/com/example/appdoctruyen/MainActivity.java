package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


import com.example.appdoctruyen.Truyen.TruyenTranh;
import com.example.appdoctruyen.adapter.TruyenTranhAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gdvDStruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> TruyenTranhArrayList;
EditText edtTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();

    }
    private void init(){
        TruyenTranhArrayList = new ArrayList<>();
        TruyenTranhArrayList.add(new TruyenTranh("muốn cả thế giới biết anh yêu em","Chương 1: Phó thị >.< Tống thị","https://sachvui.com/cover/2019/muon-ca-the-gioi-biet-anh-yeu-em.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("muốn cả thế giới biết anh yêu em","Chương 1: Phó thị >.< Tống thị","https://sachvui.com/cover/2019/muon-ca-the-gioi-biet-anh-yeu-em.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("muốn cả thế giới biết anh yêu em","Chương 1: Phó thị >.< Tống thị","https://sachvui.com/cover/2019/muon-ca-the-gioi-biet-anh-yeu-em.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Xin Chào, Người Thừa Kế","Chương 1: Tại sao cô lại ở đây?","https://sachvui.com/cover/2018/xin-chao-nguoi-thua-ke.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Xin Chào, Người Thừa Kế","Chương 1: Tại sao cô lại ở đây?","https://sachvui.com/cover/2018/xin-chao-nguoi-thua-ke.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Xin Chào, Người Thừa Kế","Chương 1: Tại sao cô lại ở đây?","https://sachvui.com/cover/2018/xin-chao-nguoi-thua-ke.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Boss Trở Thành Chồng","Chương 1: Nỗi đau mất con","https://sachvui.com/cover/2019/boss-tro-thanh-chong.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Boss Trở Thành Chồng","Chương 1: Nỗi đau mất con","https://sachvui.com/cover/2019/boss-tro-thanh-chong.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Boss Trở Thành Chồng","Chương 1: Nỗi đau mất con","https://sachvui.com/cover/2019/boss-tro-thanh-chong.jpg"));
        TruyenTranhArrayList.add(new TruyenTranh("Hôn Nhân Tàn Khốc","Chương 1","https://sachvui.com/cover/2019/hon-nhan-tan-khoc.jpg"));
        adapter = new TruyenTranhAdapter(this,0,TruyenTranhArrayList);

    }
    private void anhXa(){
        gdvDStruyen = findViewById(R.id.gdvListTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setUp(){
        gdvDStruyen.setAdapter(adapter);
    }
    private void setClick(){
    edtTimKiem.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String s1 =edtTimKiem.getText().toString();
            adapter.sortTruyen(s1);
        }
    });
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);

        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.iYeuThich:

                startActivity(new Intent(this, YeuThichActivity.class));
                break;

            case R.id.iTheLoai:
                startActivity(new Intent(this, TheLoaiActivity.class));
                break;


            case R.id.iDangXuat:
                startActivity(new Intent(this, LoginActivity.class));
                break;


                default:
                    return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}
