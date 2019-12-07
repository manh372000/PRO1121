package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


import com.example.appdoctruyen.Truyen.TruyenTranh;
import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.api.ApiLayTruyen;
import com.example.appdoctruyen.interfaces.LayTruyenVe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {

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
        new ApiLayTruyen(this).execute();
    }
    private void init(){
        TruyenTranhArrayList = new ArrayList<>();

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

    @Override
    public void batDau() {
        Toast.makeText(this,"đang lấy về",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            TruyenTranhArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                TruyenTranhArrayList.add(new TruyenTranh(o));

            }
            adapter = new TruyenTranhAdapter(this,0,TruyenTranhArrayList);
            gdvDStruyen.setAdapter(adapter);
        }catch (JSONException e){

        }

    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"lỗi kết nối",Toast.LENGTH_SHORT).show();
    }

    public void update(View view) {
        new ApiLayTruyen(this).execute();
    }
}
