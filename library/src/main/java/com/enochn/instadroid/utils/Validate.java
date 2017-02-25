package com.enochn.instadroid.utils;

/**
 * Created by enoch on 2/25/17.
 */

public class Validate {
  private static final String TAG = "Validate";

  public static void nonNullStrict(Object object, String name){
    if (object == null){
      throw new RuntimeException(name + " object passed is null");
    }
  }
}
