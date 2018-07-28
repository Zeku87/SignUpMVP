package com.demo.joseezequielgallardo.signupmvp.view;

public interface ISignUpView {

    /**
     * @param response is the presenter's response state:
     */
    public void onLoginSuccess(String response);
    public void onLoginError(String response);
}
