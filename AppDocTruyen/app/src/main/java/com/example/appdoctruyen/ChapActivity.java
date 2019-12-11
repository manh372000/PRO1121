package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.Truyen.ChapTruyen;
import com.example.appdoctruyen.Truyen.TruyenTranh;
import com.example.appdoctruyen.adapter.ChapTruyenAdapter;
import com.example.appdoctruyen.api.ApiChapTruyen;
import com.example.appdoctruyen.interfaces.LayChap;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ChapActivity extends AppCompatActivity implements LayChap {
    TextView txvTenTruyens;
    ImageView imAnhTruyens;
    TruyenTranh truyenTranh;
    ListView lsvDanhSachChap;
    ArrayList<ChapTruyen> arrChap;
    ChapTruyenAdapter chapTruyenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiChapTruyen(this).execute();
    }
    private void  init() {
        Bundle b = getIntent().getBundleExtra("data");
        truyenTranh = (TruyenTranh) b.getSerializable("truyen");
        // tao du lieu ao
        arrChap = new ArrayList<>();
        /*
        for (int i=0;i<20;i++){
           arrChap.add(new ChapTruyen("Chapter "+i,"06-10-2019"));

        }
        chapTruyenAdapter= new ChapTruyenAdapter(this,0,arrChap);
    }*/
    }
    private void  anhXa(){
        imAnhTruyens = findViewById(R.id.imAnhTruyens);
        txvTenTruyens = findViewById(R.id.txvTenTruyens);
        lsvDanhSachChap = findViewById(R.id.lsvDanhSachChap);
    }
    private void  setUp(){
        txvTenTruyens.setText(truyenTranh.getTenTruyen());
        Glide.with(this).load(truyenTranh.getLinkAnh()).into(imAnhTruyens);
      //  lsvDanhSachChap.setAdapter(chapTruyenAdapter);
    }
    private void  setClick(){
        lsvDanhSachChap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                startActivity(new Intent(ChapActivity.this,DocTruyenActivity.class));
            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"Lay Chap Ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            JSONArray array = new JSONArray(data);
            for (int i=0;i<array.length();i++ ){
                ChapTruyen chapTruyen =new ChapTruyen(array.getJSONObject(i));
                arrChap.add(chapTruyen);
            }
            chapTruyenAdapter= new ChapTruyenAdapter(this,0,arrChap);
            lsvDanhSachChap.setAdapter(chapTruyenAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void biLoi() {

    }
}
