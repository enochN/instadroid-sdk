package com.enochn.instadroid.auth;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by enoch on 3/18/17.
 */

public class SignInButton extends android.support.v7.widget.AppCompatButton {

  public SignInButton(Context context) {
    super(context);
    setClickable(true);
    setFocusable(true);
  }

  public SignInButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    setClickable(true);
    setFocusable(true);
  }

  public SignInButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    setClickable(true);
    setFocusable(true);
  }

}
