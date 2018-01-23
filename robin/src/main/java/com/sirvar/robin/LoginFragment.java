package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginFragment extends Fragment {

    private RelativeLayout layout;

    private TextView title;
    private TextView signup;
    private TextView forgotPassword;
    private ImageView logo;
    private EditText email;
    private EditText password;
    private TextInputLayout emailWrapper;
    private TextInputLayout passwordWrapper;
    private Button submit;

    private ImageButton google;
    private ImageButton facebook;
    private boolean showLogin;

    private Typeface typeface;
    private String titleText;
    private Drawable logoDrawable;
    private Bitmap logoBitmap;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Initialize views
        title = view.findViewById(R.id.title);
        signup = view.findViewById(R.id.signup);
        forgotPassword = view.findViewById(R.id.forgotPassword);
        logo = view.findViewById(R.id.logo);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        emailWrapper = view.findViewById(R.id.wrapper_email);
        passwordWrapper = view.findViewById(R.id.wrapper_password);
        submit = view.findViewById(R.id.submit);
        google = view.findViewById(R.id.google_login);
        facebook = view.findViewById(R.id.facebook_login);
        layout=view.findViewById(R.id.login_layout);


        ((RobinActivity) getActivity()).onLoginFragmentCreated(this);



        // Login form submitted
        submit.setOnClickListener(v -> {
            if (fieldsFilled()) {
                ((RobinActivity) getActivity()).onLogin(email.getText().toString(), password.getText().toString());
            } else {
                Toast.makeText(getContext(), "Some information is missing.", Toast.LENGTH_SHORT).show();
            }
        });

        google.setOnClickListener(v -> ((RobinActivity) getActivity()).onGoogleLogin());

        facebook.setOnClickListener(v -> ((RobinActivity) getActivity()).onFacebookLogin());

        forgotPassword.setOnClickListener(v -> ((RobinActivity) getActivity()).startForgotPasswordFragment());

        signup.setOnClickListener(v -> ((RobinActivity) getActivity()).startSignupFragment());

        if (!showLogin) {
            google.setVisibility(View.INVISIBLE);
            facebook.setVisibility(View.INVISIBLE);
        }

        setDefaults();

        return view;
    }

    /**
     * Get title for fragment
     *
     * @param titleText fragment title
     */
    public void setTitle(String titleText) {
        this.titleText = titleText;
    }

    /**
     * Set title for fragment
     */
    private void setTitle() {
        title.setText(titleText);
    }

    /**
     * Get drawable image for logo
     *
     * @param drawable drawable logo
     */
    public void setImage(Drawable drawable) {
        logoDrawable = drawable;
    }

    /**
     * Set bitmap image for logo
     *
     * @param bitmap bitmap logo
     */
    public void setImage(Bitmap bitmap) {
        logoBitmap = bitmap;
    }

    /**
     * Set image for logo
     */
    private void setImage() {
        if (logoDrawable != null) {
            logo.setImageDrawable(logoDrawable);
        } else if (logoBitmap != null) {
            logo.setImageBitmap(logoBitmap);
        }
    }

    /**
     * Get custom font for all Views
     *
     * @param typeface custom typeface
     */
    public void setFont(Typeface typeface) {
        this.typeface = typeface;
    }

    /**
     * Set custom font for all Views
     */
    private void setFont() {
        title.setTypeface(typeface);
        signup.setTypeface(typeface);
        forgotPassword.setTypeface(typeface);
        email.setTypeface(typeface);
        password.setTypeface(typeface);
        emailWrapper.setTypeface(typeface);
        passwordWrapper.setTypeface(typeface);
        submit.setTypeface(typeface);
    }

    protected void showSocialLogin(boolean showLogin) {
        this.showLogin = showLogin;
    }

    private boolean fieldsFilled() {


        for( int i = 0; i < layout.getChildCount(); i++ ) {

            if (layout.getChildAt(i) instanceof TextInputLayout)
            {
                TextInputLayout input= (TextInputLayout) layout.getChildAt(i);

                if (!isFieldFilled(input.getEditText()))
                {
                    return false;
                }

            }
            else if (layout.getChildAt(i) instanceof FrameLayout)
            {
                FrameLayout input= (FrameLayout) layout.getChildAt(i);

               //ugly hack to get to the password
                TextInputLayout child = (TextInputLayout) input.getChildAt(0);
                if (!isFieldFilled(child.getEditText()))
                {
                    return false;
                }

            }
        }
        return true;

    }

    /**
     *
     * @param edit
     * @return true if a field is {@link android.view.View#VISIBLE} and filled out or if it's
     * not visible
     */
    private boolean isFieldFilled(EditText edit) {

        return edit.getVisibility() != View.VISIBLE || (edit.getText().toString() != null && !edit.getText().toString().trim().isEmpty());
    }



    private void setDefaults() {
        setTitle();
        setFont();
        setImage();
    }


    /**
     *
     * @param visibility .- The {@link android.view.View} Visibility for this field
     * @param hint .- The hint for this Field. Will use default if null
     */
    public void setEmailField(int visibility, @Nullable String hint)
    {
        email.setVisibility(visibility);
        if (hint!=null)
        {
            emailWrapper.setHint(hint);
            email.setHint(hint);
        }
    }


    /**
     *
     * @param visibility .- The {@link android.view.View} Visibility for this field
     * @param hint .- The hint for this Field. Will use default if null
     */
    public void setForgotPassword(int visibility, @Nullable String hint)
    {
        forgotPassword.setVisibility(visibility);
        if (hint!=null)
        {
            forgotPassword.setHint(hint);
            forgotPassword.setText(hint);
        }
    }

    /**
     *
     * @param visibility .- The {@link android.view.View} Visibility for this field
     * @param hint .- The hint for this Field. Will use default if null
     */
    public void setPasswordField(int visibility, @Nullable String hint)
    {
        password.setVisibility(visibility);
        forgotPassword.setVisibility(visibility);

        if (hint!=null)
        {
            passwordWrapper.setHint(hint);
            password.setHint(hint);
        }
    }


    public EditText getEmail() {
        return email;
    }

    public EditText getPassword() {
        return password;
    }

    public TextView getForgotPassword() {
        return forgotPassword;
    }
}
