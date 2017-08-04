package com.sirvar.robin.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Toast;

import com.sirvar.robin.RobinActivity;
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
    protected void onLogin(String email, String password) {
        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSignup(String name, String email, String password) {
        Toast.makeText(getApplicationContext(), "Signup", Toast.LENGTH_SHORT).show();
        // Make API call
    }

    @Override
    protected void onForgotPassword(String email) {
        Toast.makeText(getApplicationContext(), "Forgot Password", Toast.LENGTH_SHORT).show();
        // Make API call
        // After sent password email callback
        startLoginFragment();
    }

    @Override
    protected void onGoogleLogin() {
        Toast.makeText(getApplicationContext(), "Google", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onFacebookLogin() {
        Toast.makeText(getApplicationContext(), "Facebook", Toast.LENGTH_SHORT).show();
    }
}
