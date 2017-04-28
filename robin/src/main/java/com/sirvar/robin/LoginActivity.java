package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class LoginActivity extends AppCompatActivity {

    private TextView title;
    private ImageView logo;
    private EditText email;
    private EditText password;
    private Theme theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin_login);

        getSupportActionBar().hide();

        title = (TextView) findViewById(R.id.title);
        logo = (ImageView) findViewById(R.id.logo);

        setDefaults();
    }

    /**
     * Override form submission
     *
     * @param email username or email address entered by user
     * @param password raw password
     */
    protected abstract void onSubmit(String email, String password);

    /**
     * Set title for activity
     * @param title activity title
     */
    protected void setTitle(String title) {
        this.title.setText(title);
    }

    /**
     * Set theme for activity
     * @param theme Light or Dark theme
     */
    protected void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Set drawable image for logo
     * @param drawable drawable logo
     */
    protected void setImage(Drawable drawable) {
        logo.setImageDrawable(drawable);
    }

    /**
     * Set bitmap image for logo
     * @param bitmap bitmap logo
     */
    protected void setImage(Bitmap bitmap) {
        logo.setImageBitmap(bitmap);
    }

    /**
     * Set default values
     */
    private void setDefaults() {
        title.setText(R.string.login);
        theme = Theme.LIGHT;
    }
}
