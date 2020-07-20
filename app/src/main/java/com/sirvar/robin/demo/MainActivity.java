package com.sirvar.robin.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sirvar.robin.LoginFragment;
import com.sirvar.robin.RobinActivity;
import com.sirvar.robin.SignupFragment;
import com.sirvar.robin.Theme;

public class MainActivity extends RobinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLoginTitle("Sign in to Robin");
        setSignupTitle("Welcome to Robin");
        setForgotPasswordTitle("Forgot Password");
        setImage(getResources().getDrawable(R.drawable.logo));
        setFont(Typeface.createFromAsset(getAssets(), "Montserrat-Medium.ttf"));
        setTheme(Theme.LIGHT);
        enableSocialLogin();
        showLoginFirst();
    }

    @Override
    public void onSignupFragmentCreated(SignupFragment signupFragment) {
       // Example on how to customize the Signup Fragment. If a text input is not
        // visible, it won't be validated when the form is submitted
//        signupFragment.setNameField(View.VISIBLE,"Your name");
//        signupFragment.setEmailField(View.VISIBLE,"Your email");
//        signupFragment.setPasswordField(View.GONE,null);
    }


    @Override
    public void onLoginFragmentCreated(LoginFragment loginFragment) {
//          Example on how to customize the LoginFragment
//        loginFragment.setEmailField(View.VISIBLE,"your email");
//        loginFragment.setPasswordField(View.GONE,null);



    }

    @Override
    public void onLogin(String email, String password) {
        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignup(String name, String email, String password) {
        Toast.makeText(getApplicationContext(), "Signup", Toast.LENGTH_SHORT).show();
        // Make API call
    }

    @Override
    public void onForgotPassword(String email) {
        Toast.makeText(getApplicationContext(), "Forgot Password", Toast.LENGTH_SHORT).show();
        // Make API call
        // After sent password email callback
        startLoginFragment();
    }

    @Override
    public void onGoogleLogin() {
        Toast.makeText(getApplicationContext(), "Google", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFacebookLogin() {
        Toast.makeText(getApplicationContext(), "Facebook", Toast.LENGTH_SHORT).show();
    }
}
