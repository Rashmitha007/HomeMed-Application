package com.example.homeremedy;


import android.os.health.UidHealthStats;

import java.util.jar.Attributes;

public class Users {
    public String getUid(){
        return Uid;

    }
    public void setUid(String uid){
        Uid=uid;

    }
    private String Uid;
    private String username;
    private String password;
    private String email;
    private String phone;

    public Users(){

    }
    public Users(String uid,String username,String password,String email,String phone,int usertype){
        Uid=uid;
        username=username;
        password=password;
        email=email;
        phone=phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
