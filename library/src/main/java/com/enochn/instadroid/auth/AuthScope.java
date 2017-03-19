package com.enochn.instadroid.auth;

/**
 * Created by enoch on 3/19/17.
 */

public enum AuthScope {
  BASIC("basic"),
  PUBLIC_CONTENT("public_content"),
  FOLLOWER_LIST("follower_list"),
  COMMENTS("comments"),
  RELATIONSHIPS("relationships"),
  LIKES("likes");

  String scope;
  AuthScope(String s){
    this.scope = s;
  }

  @Override
  public String toString() {
    return this.scope;
  }
}
