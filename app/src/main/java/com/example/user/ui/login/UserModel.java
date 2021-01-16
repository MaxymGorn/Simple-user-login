package com.example.user.ui.login;

import android.text.Editable;

import java.io.Serializable;

public class UserModel implements Serializable {
    public UserModel(String userFirstName, String userSecondName){
        this.userFirstName=userFirstName;
        this.userSecondName=userSecondName;
    }
    public String userFirstName;
    public String userSecondName;

}
