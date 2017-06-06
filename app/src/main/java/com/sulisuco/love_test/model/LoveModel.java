/*
 * Love-Test - LoveModel.java
 * Create by Izma R. Ramirez - sulisu.co on 5/06/17 11:34 PM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 5/06/17 11:34 PM
 *
 * - 5/06/17 11:34 PM
 * - - ...
 *
 * - ...
 * - - ...
 */

package com.sulisuco.love_test.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class LoveModel {

    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("sname")
    @Expose
    private String sname;
    @SerializedName("percentage")
    @Expose
    private String percentage;
    @SerializedName("result")
    @Expose
    private String result;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
