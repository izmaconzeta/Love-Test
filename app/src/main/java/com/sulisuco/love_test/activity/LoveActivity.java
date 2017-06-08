/*
 * Love-Test - LoveActivity.java
 * Create by Izma R. Ramirez - sulisu.co on 5/06/17 11:54 PM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 5/06/17 11:54 PM
 *
 * - 5/06/17 11:54 PM
 * - - The connector to consume the API was created
 * - 7/06/17 10:39 PM
 * - - Correction of elements name and change of "List <something>" in the request
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

    TextView rlt_tv_loveTest;
    TextView rlt_tv_percentage;
    TextView rlt_tv_result;

    EditText rlt_et_yourName;
    EditText rlt_et_hisName;

    Button rlt_bt_calculate;

    String loveTest;
    String percentage;
    String result;
    String yourName;
    String hisName;

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.resposive_love_test);

        rlt_tv_loveTest = (TextView) findViewById(R.id.rlt_tv_loveTest);
        rlt_tv_percentage = (TextView) findViewById(R.id.rlt_tv_percentage);
        rlt_tv_result = (TextView) findViewById(R.id.rlt_tv_result);
        rlt_et_yourName = (EditText) findViewById(R.id.rlt_et_yourName);
        rlt_et_hisName = (EditText) findViewById(R.id.rlt_et_hisName);
        rlt_bt_calculate = (Button) findViewById(R.id.rlt_bt_calculate);

        rlt_bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourName = rlt_et_yourName.getText().toString();
                hisName = rlt_et_hisName.getText().toString();

                Logger.d("yourName: %s\nhisName: %s",yourName,hisName);
                loveConnector();
            }
        });

    }

    void loveConnector(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://love-calculator.p.mashape.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoveClient loveClient = retrofit.create(LoveClient.class);

        Call<LoveModel> loveModelCall = loveClient.getLove(yourName,hisName);

        loveModelCall.enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                switch (response.code()){
                    case 200:
                        Logger.d("200");
                        Logger.d("yourName: %s\nhisName: %s\npercentage: %s\nresult: %s\n",
                                response.body().getFname(),
                                response.body().getSname(),
                                response.body().getPercentage(),
                                response.body().getResult());
                        percentage = response.body().getPercentage();
                        result = response.body().getResult();
                        rlt_tv_percentage.setText("%" + percentage);
                        rlt_tv_result.setText(result);
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
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Logger.e("Error", t.getMessage());
                Logger.e(t, "Learn something error");
                TastyToast.makeText(getApplicationContext(), "Petition Error", TastyToast.LENGTH_LONG, TastyToast.ERROR);

            }
        });
    }


}
