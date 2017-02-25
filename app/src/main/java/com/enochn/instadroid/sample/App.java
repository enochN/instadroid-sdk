package com.enochn.instadroid.sample;

import android.app.Application;
import android.util.Log;
import com.enochn.instadroid.Instadroid;

/**
 * Created by enoch on 2/25/17.
 */

public class App extends Application {

  private static final String TAG = "App";

  @Override
  public void onCreate() {
    super.onCreate();
    Instadroid.init(getApplicationContext());
    Log.e(TAG, "onCreate:  clientId : " + String.valueOf(Instadroid.getInstagramClientId()));
    Log.e(TAG, "onCreate:  clientSecret : " + String.valueOf(Instadroid.getInstagramClientSecret()));
  }
}
