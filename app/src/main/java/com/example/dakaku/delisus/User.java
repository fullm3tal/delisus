package com.example.dakaku.delisus;

/**
 * Created by dakaku on 19/1/18.
 */

public class User {

    private String mEmail;
    private String mUsername;

    public User() {
    }

    public User(String email, String username) {
        this.mEmail = email;

        mUsername=username;
    }

    public String getEmail() {
        return mEmail;
    }


    public  String getUsername(){
        return mUsername;
    }

    @Override
    public String toString() {
        return "User{" +
                "mEmail='" + mEmail + '\'' +
                ", mUsername='" + mUsername + '\'' +
                '}';
    }
}
