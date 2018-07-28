package com.demo.joseezequielgallardo.signupmvp.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email;
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Check if
     * email matches the pattern properly
     * password is empty
     * password length is greater than 6
     */
    @Override
    public boolean isValidData() {
        return (!isEmailAddressMalformed() && !isEmailOrPasswordEmpty() && !isPasswordLengthLessThanSevenChars());
    }

    @Override
    public boolean isEmailOrPasswordEmpty(){
        return (TextUtils.isEmpty(getEmail()) || TextUtils.isEmpty(getPassword()));
    }

    @Override
    public boolean isEmailAddressMalformed(){
        return !Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    @Override
    public boolean isPasswordLengthLessThanSevenChars(){
        return getPassword().length() < 7;
    }
}
