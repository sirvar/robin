package com.sirvar.robin.demo;

import android.graphics.Typeface;
import android.os.Bundle;

import com.sirvar.robin.RobinActivity;
import com.sirvar.robin.Theme;

public class MainActivity extends RobinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLoginTitle("Sign in to Robin");
        setImage(getResources().getDrawable(R.mipmap.ic_launcher));
        setFont(Typeface.createFromAsset(getAssets(), "Montserrat-Medium.ttf"));
        setTheme(Theme.LIGHT);
    }

    @Override
    protected void onLogin(String email, String password) {
        // Make request to API
    }
}
