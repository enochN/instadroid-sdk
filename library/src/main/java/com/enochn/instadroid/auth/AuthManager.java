package com.enochn.instadroid.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.enochn.instadroid.utils.InstadroidRuntimeException;
import com.enochn.instadroid.utils.Validate;

/**
 * Created by enoch on 3/18/17.
 */

public class AuthManager {
  private AuthManager INSTANCE;
  private Context applicationContext;
  private static final int LOGIN_REQUEST_CODE = 602434377;
  private StartActivityDelegate startActivityDelegate;

  public static AuthManager getInstance(Context context) {
    return new AuthManager(context);
  }

  private AuthManager(Context context){
    applicationContext = context.getApplicationContext();
  }

  public void startLoginProcess(Activity activity, AuthScope... scopes){
    if(scopes == null || scopes.length < 1){
      throw new InstadroidRuntimeException("No AuthScopes supplied");
    }
    startActivityDelegate = new ActivityStartActivityDelegate(activity);
    Intent intent = new Intent(startActivityDelegate.getActivityContext(), InstagramLoginActivity.class);
    String scopeParam = "";
    for (AuthScope scope : scopes){
      scopeParam += scope.toString() + "+";
    }
    scopeParam = scopeParam.substring(0, scopeParam.lastIndexOf("+"));
    intent.putExtra("scopeParam", scopeParam);
    startActivityDelegate.startActivityForResult(intent, LOGIN_REQUEST_CODE);
  }


  private static class ActivityStartActivityDelegate implements StartActivityDelegate {
    private Activity activity;

    ActivityStartActivityDelegate(final Activity activity){
      Validate.nonNullStrict(activity, "activity");
      this.activity = activity;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
      activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public Activity getActivityContext() {
      return activity;
    }
  }
}
