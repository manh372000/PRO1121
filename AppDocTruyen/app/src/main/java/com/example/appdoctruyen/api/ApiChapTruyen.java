package com.example.appdoctruyen.api;

import android.os.AsyncTask;

import com.example.appdoctruyen.interfaces.LayChap;
import com.example.appdoctruyen.interfaces.LayTruyenVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiChapTruyen extends AsyncTask<Void,Void,Void> {
    String data;
    LayChap LayChap;

    public ApiChapTruyen(LayChap LayChap) {
        this.LayChap = LayChap;
        this.LayChap.batDau();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()

                .url("https://api.myjson.com/bins/1h4d3g")
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data=body.string();
        }catch (IOException e){
            data=null;

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data==null){
            this.LayChap.biLoi();
        }else {
            this.LayChap.ketThuc(data);
        }
    }
}
