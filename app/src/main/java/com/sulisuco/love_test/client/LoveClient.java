/*
 * Love-Test - ModelClient.java
 * Create by Izma R. Ramirez - sulisu.co on 5/06/17 11:38 PM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 5/06/17 11:38 PM
 *
 * - 5/06/17 11:38 PM
 * - - The client was created for the Retrofit request
 *
 * - ...
 * - - ...
 */

package com.sulisuco.love_test.client;

import com.sulisuco.love_test.model.LoveModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface LoveClient {
    @Headers({"Accept:application/json","X-Mashape-Key: szwC8iPVQDmshygh3ZLGlSMqsfx3p1nWNzUjsnuErHQ1FtC4W"})
    @GET("/getPercentage?fname={name_one}&sname={name_two}")
    Call<List<LoveModel>> getLove(@Path("name_one") String name_one,@Path("name_two") String name_two);

}
