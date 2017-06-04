/*
 * Love-Test - ExampleInstrumentedTest.java
 * Create by Izma R. Ramirez - sulisu.co on 4/06/17 02:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Last modified date 4/06/17 02:05 AM
 *
 * - 4/06/17 02:06 AM
 * - - ...
 *
 * - ...
 * - - ...
 */

package com.sulisuco.love_test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.sulisuco.love_test", appContext.getPackageName());
    }
}
