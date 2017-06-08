/*
 * Love-Test - LoveActivity.java
 * Create by Izma R. Ramirez - sulisu.co on 5/06/17 11:54 PM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 5/06/17 11:54 PM
 *
 * - 5/06/17 11:54 PM
 * - - The connector to consume the API was created
 *
 * - ...
 * - - ...
 */

package com.sulisuco.love_test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sdsmdg.tastytoast.TastyToast;
import com.sulisuco.love_test.R;
import com.sulisuco.love_test.client.LoveClient;
import com.sulisuco.love_test.model.LoveModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoveActivity extends AppCompatActivity {

    EditText et_name_one;
    EditText et_name_two;
    TextView percentage;
    TextView result;
    Button calculate;

    int aux01;
    int aux02;

    String name_one;
    String name_two;

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.love_test);

        et_name_one = (EditText) findViewById(R.id.name_one);
        et_name_two = (EditText) findViewById(R.id.name_two);
        percentage = (TextView) findViewById(R.id.percentage);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_one = et_name_one.getText().toString();
                name_two = et_name_two.getText().toString();

                Logger.d("%s\n%n", name_one,name_two);
            }
        });
    }

    void loveConnector(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://love-calculator.p.mashape.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoveClient loveClient = retrofit.create(LoveClient.class);

        Call<List<LoveModel>> loveModelCall = loveClient.getLove(name_one,name_two);

        loveModelCall.enqueue(new Callback<List<LoveModel>>() {
            @Override
            public void onResponse(Call<List<LoveModel>> call, Response<List<LoveModel>> response) {
                switch (response.code()){
                    case 200:
                        Logger.d("200");
                        TastyToast.makeText(getApplicationContext(), "Petition Successful !", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                        break;

                    case 400:
                        Logger.w("400");
                        TastyToast.makeText(getApplicationContext(), "400", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        break;

                    case 401:
                        Logger.w("401");
                        TastyToast.makeText(getApplicationContext(), "401", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        break;

                    case 404:
                        Logger.w("404");
                        TastyToast.makeText(getApplicationContext(), "404", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        break;


                    case 500:
                        Logger.e("500");
                        TastyToast.makeText(getApplicationContext(), "500", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        break;

                    default:
                        Logger.w("Error : %s", response.code());
                        TastyToast.makeText(getApplicationContext(), "Unknown Error", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<LoveModel>> call, Throwable t) {
                Logger.e("Error", t.getMessage());
                Logger.e(t, "Learn something error");
                TastyToast.makeText(getApplicationContext(), "Petition Error", TastyToast.LENGTH_LONG, TastyToast.ERROR);

            }
        });
    }


}
