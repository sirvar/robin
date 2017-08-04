package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;

public abstract class RobinActivity extends AppCompatActivity {

    private LoginFragment loginFragment;
    private SignupFragment signupFragment;
    private ForgotPasswordFragment forgotPasswordFragment;

    private String loginTitle;
    private String signupTitle;
    private String forgotPasswordTitle;
    private Drawable logoDrawable;
    private Bitmap logoBitmap;
    private Typeface typeface;

    private boolean loginFirst = true;
    private boolean socialLogin = true;

    private Theme theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin);

        // Don't show toolbar
        getSupportActionBar().hide();

        loginFragment = new LoginFragment();
        signupFragment = new SignupFragment();
        forgotPasswordFragment = new ForgotPasswordFragment();

        setDefaults();
    }

    /**
     * Override form login
     *
     * @param email    username or email address entered by user
     * @param password raw password
     */
    protected abstract void onLogin(String email, String password);

    /**
     * Override form signup
     *
     * @param email    username or email address entered by user
     * @param password raw password
     */
    protected abstract void onSignup(String name, String email, String password);

    /**
     * Override form forgot password
     *
     * @param email    username or email address entered by user
     */
    protected abstract void onForgotPassword(String email);

    /**
     * Override form Google login
     */
    protected abstract void onGoogleLogin();

    /**
     * Override form Facebook login
     */
    protected abstract void onFacebookLogin();

    /**
     * Enables social login button
     */
    protected void enableSocialLogin() {
        socialLogin = true;
        loginFragment.showSocialLogin(socialLogin);
    }

    /**
     * Hides social login buttons
     */
    protected void disableSocialLogin() {
        socialLogin = false;
        loginFragment.showSocialLogin(socialLogin);
    }

    protected void showLoginFirst() {
        loginFirst = true;
        if (findViewById(R.id.fragment_container) != null) {
            startLoginFragment();
        }
    }

    protected void showSignupFirst() {
        loginFirst = false;
        if (findViewById(R.id.fragment_container) != null) {
            startSignupFragment();
        }
    }

    /**
     * Launches login fragment
     */
    protected void startLoginFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit();
    }

    /**
     * Launches forgot password fragment
     */
    protected void startForgotPasswordFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, forgotPasswordFragment)
                .commit();
    }

    /**
     * Launches signup fragment
     */
    protected void startSignupFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, signupFragment)
                .commit();
    }

    /**
     * Set title for login fragment
     *
     * @param title login title
     */
    protected void setLoginTitle(String title) {
        loginTitle = title;
        loginFragment.setTitle(loginTitle);
    }

    /**
     * Set title for signup fragment
     *
     * @param title login title
     */
    protected void setSignupTitle(String title) {
        signupTitle = title;
        signupFragment.setTitle(signupTitle);
    }

    /**
     * Set title for forgot password fragment
     *
     * @param title login title
     */
    protected void setForgotPasswordTitle(String title) {
        forgotPasswordTitle = title;
        forgotPasswordFragment.setTitle(forgotPasswordTitle);
    }

    /**
     * Set theme for activity
     *
     * @param theme from list of themes in enum
     */
    protected void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Set drawable image for logo
     *
     * @param drawable drawable logo
     */
    protected void setImage(Drawable drawable) {
        logoDrawable = drawable;
        loginFragment.setImage(logoDrawable);
        signupFragment.setImage(logoDrawable);
        forgotPasswordFragment.setImage(logoDrawable);
    }

    /**
     * Set bitmap image for logo
     *
     * @param bitmap bitmap logo
     */
    protected void setImage(Bitmap bitmap) {
        logoBitmap = bitmap;
        loginFragment.setImage(logoBitmap);
        signupFragment.setImage(logoBitmap);
        forgotPasswordFragment.setImage(logoBitmap);
    }

    /**
     * Use custom font for all Views
     *
     * @param typeface custom typeface
     */
    protected void setFont(Typeface typeface) {
        this.typeface = typeface;
        loginFragment.setFont(typeface);
        signupFragment.setFont(typeface);
        forgotPasswordFragment.setFont(typeface);
    }

    /**
     * Set default values
     */
    private void setDefaults() {
        showLoginFirst();
        theme = Theme.LIGHT;
    }
}
