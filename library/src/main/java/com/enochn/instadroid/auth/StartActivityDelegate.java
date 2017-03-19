package com.enochn.instadroid.auth;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by enoch on 3/19/17.
 */

public interface StartActivityDelegate {
  public void startActivityForResult(Intent intent, int requestCode);
  public Activity getActivityContext();
}
