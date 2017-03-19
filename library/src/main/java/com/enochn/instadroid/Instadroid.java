package com.enochn.instadroid;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.enochn.instadroid.utils.Validate;


public final class Instadroid {
  private static final String TAG = Instadroid.class.getCanonicalName();
  private static Boolean sdkInitialized = false;
  private static Context applicationContext;
  public static final String BASE_URL = "https://api.instagram.com/v1";
  public static final String AUTHORIZATION_URL = "https://api.instagram.com/oauth/authorize/?";
  private static final String INSTAGRAM_CLIENT_ID_KEY = "com.enochn.instadroid.sdk.client_id";
  private static final String INSTAGRAM_CLIENT_SECRET_KEY = "com.enochn.instadroid.sdk.client_secret";
  private static final String INSTAGRAM_REDIRECT_URI_KEY = "com.enochn.instadroid.sdk.redirect_uri";
  private static volatile String instagramClientId;
  private static volatile String instagramClientSecret;
  private static volatile String instagramRedirectUri;

  public static synchronized void init(Context applicationContext){
    if (sdkInitialized){
      Log.d(TAG, "init: Instadriod SDK Initialized");
      return;
    }
    Validate.nonNullStrict(applicationContext, "applicationContext");
    Instadroid.applicationContext = applicationContext.getApplicationContext();
    Instadroid.loadConfigFromMetadata(Instadroid.applicationContext);

    sdkInitialized = true;
  }

  private static void loadConfigFromMetadata(Context context){
    if (context == null){
      return;
    }

    ApplicationInfo appInfo;
    try {
      appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),
          PackageManager.GET_META_DATA);
    }catch (PackageManager.NameNotFoundException e){
      return;
    }

    if (appInfo == null || appInfo.metaData == null){
      return;
    }

    if (instagramClientId == null){
      instagramClientId = appInfo.metaData.getString(INSTAGRAM_CLIENT_ID_KEY);
    }

    if (instagramClientSecret == null){
      instagramClientSecret = appInfo.metaData.getString(INSTAGRAM_CLIENT_SECRET_KEY);
    }

    if (instagramRedirectUri == null){
      instagramRedirectUri = appInfo.metaData.getString(INSTAGRAM_REDIRECT_URI_KEY);
    }
  }


  public static String getInstagramClientId(){
    return instagramClientId;
  }

  public static String getInstagramClientSecret(){
    return instagramClientSecret;
  }
}
