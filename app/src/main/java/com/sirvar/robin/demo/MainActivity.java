package com.sirvar.robin.demo;

import android.graphics.Typeface;
import android.os.Bundle;

import com.sirvar.robin.SigninActivity;
import com.sirvar.robin.Theme;

public class MainActivity extends SigninActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Sign in to Robin");
        setImage(getResources().getDrawable(R.mipmap.ic_launcher));
        setFont(Typeface.createFromAsset(getAssets(), "Montserrat-Medium.ttf"));
        setTheme(Theme.LIGHT);
    }

    @Override
    protected void onSubmit(String email, String password) {
        // Make request to API
    }
}
