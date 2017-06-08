/*
 * Love-Test - ModelClient.java
 * Create by Izma R. Ramirez - sulisu.co on 5/06/17 11:38 PM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 5/06/17 11:38 PM
 *
 * - 5/06/17 11:38 PM
 * - - The client was created for the Retrofit request
 * - 7/06/17 10:39 PM
 * - - Change of request, from "Path" to "Query" and error correction of the request
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
import retrofit2.http.Query;

public interface LoveClient {
    @Headers({"Accept: application/json","X-Mashape-Key: w5CDZDVr8Nmsh4Q2lxN8bAWTTu4lp1KtVIEjsnaNWa2oMz19a8"})
    @GET("/getPercentage")
    Call<LoveModel> getLove(@Query("fname") String yourName, @Query("sname") String hisName);

}
