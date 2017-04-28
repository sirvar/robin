package com.sirvar.robin.demo;

import android.os.Bundle;

import com.sirvar.robin.LoginActivity;
import com.sirvar.robin.Theme;

public class MainActivity extends LoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Login");
        setImage(getResources().getDrawable(R.mipmap.ic_launcher));
        setTheme(Theme.LIGHT);
    }

    @Override
    protected void onSubmit(String email, String password) {
        // Make request to API
    }
}
