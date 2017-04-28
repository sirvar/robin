package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class SigninActivity extends AppCompatActivity {

    private TextView title;
    private TextView signup;
    private ImageView logo;
    private EditText email;
    private EditText password;
    private TextInputLayout emailWrapper;
    private TextInputLayout passwordWrapper;
    private Button submit;
    private Theme theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin_signin);

        // Don't show toolbar
        getSupportActionBar().hide();

        // Initialize views
        title = (TextView) findViewById(R.id.title);
        signup = (TextView) findViewById(R.id.signup);
        logo = (ImageView) findViewById(R.id.logo);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        emailWrapper = (TextInputLayout) findViewById(R.id.wrapper_email);
        passwordWrapper = (TextInputLayout) findViewById(R.id.wrapper_password);
        submit = (Button) findViewById(R.id.submit);

        // Login form submitted
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit(email.getText().toString(), password.getText().toString());
            }
        });

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
     * Use custom font for all Views
     * @param typeface custom typeface
     */
    protected void setFont(Typeface typeface) {
        title.setTypeface(typeface);
        signup.setTypeface(typeface);
        email.setTypeface(typeface);
        password.setTypeface(typeface);
        emailWrapper.setTypeface(typeface);
        passwordWrapper.setTypeface(typeface);
        submit.setTypeface(typeface);
    }

    /**
     * Set default values
     */
    private void setDefaults() {
        title.setText(R.string.signin);
        theme = Theme.LIGHT;
    }
}
