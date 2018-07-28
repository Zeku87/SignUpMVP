package com.demo.joseezequielgallardo.signupmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.joseezequielgallardo.signupmvp.presenter.ISignUp;
import com.demo.joseezequielgallardo.signupmvp.presenter.SignUp;
import com.demo.joseezequielgallardo.signupmvp.view.ISignUpView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ISignUpView {

    EditText emailEditText;
    EditText passwordEditText;
    Button signInButton;

    private ISignUp login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        signInButton = findViewById(R.id.sign_in_button);

        login = new SignUp(MainActivity.this, MainActivity.this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //it requests verification to the Presenter
                login.onLogin(email, password);
            }
        });
    }

    @Override
    public void onLoginSuccess(String response) {
        Toasty.success(MainActivity.this, response, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void onLoginError(String response) {
        Toasty.error(MainActivity.this, response, Toast.LENGTH_SHORT, true).show();
    }
}
