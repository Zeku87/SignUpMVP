package com.demo.joseezequielgallardo.signupmvp.model;

public interface IUser {
    public String getEmail();
    public String getPassword();
    public boolean isValidData();
    public boolean isEmailOrPasswordEmpty();
    public boolean isEmailAddressMalformed();
    public boolean isPasswordLengthLessThanSevenChars();
}
