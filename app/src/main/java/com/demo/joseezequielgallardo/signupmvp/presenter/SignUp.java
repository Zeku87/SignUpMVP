package com.demo.joseezequielgallardo.signupmvp.presenter;

import android.content.Context;

import com.demo.joseezequielgallardo.signupmvp.R;
import com.demo.joseezequielgallardo.signupmvp.model.User;
import com.demo.joseezequielgallardo.signupmvp.view.ISignUpView;

public class SignUp implements ISignUp {

    private ISignUpView view;
    private Context context;

    /**
     * Expects MainActivity Context so the presenter can respond to the view
     * @param view
     */
    public SignUp(ISignUpView view, Context context){
        this.view = view;
        this.context = context;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);

        //Presenter's response to the View(method implemented by MainActivity)
        if(user.isValidData()){
            view.onLoginSuccess(context.getString(R.string.sign_up_success));
        }

        else if (user.isEmailOrPasswordEmpty()){
            view.onLoginError(context.getString(R.string.empty_error));
        }

        else if(user.isEmailAddressMalformed()) {
            view.onLoginError(context.getString(R.string.email_pattern_error));
        }

        else if (user.isPasswordLengthLessThanSevenChars()){
            view.onLoginError(context.getString(R.string.pass_length_error));
        }
    }
}
