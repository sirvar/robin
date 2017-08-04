package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

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
        title = (TextView) view.findViewById(R.id.title);
        signup = (TextView) view.findViewById(R.id.signup);
        forgotPassword = (TextView) view.findViewById(R.id.forgotPassword);
        logo = (ImageView) view.findViewById(R.id.logo);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        emailWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_email);
        passwordWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_password);
        submit = (Button) view.findViewById(R.id.submit);
        google = (ImageButton) view.findViewById(R.id.google_login);
        facebook = (ImageButton) view.findViewById(R.id.facebook_login);

        // Login form submitted
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fieldsFilled()) {
                    ((RobinActivity) getActivity()).onLogin(email.getText().toString(), password.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Some information is missing.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).onGoogleLogin();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).onFacebookLogin();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).startForgotPasswordFragment();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).startSignupFragment();
            }
        });

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
        return !(email.getText().toString().isEmpty() || password.getText().toString().isEmpty());
    }

    private void setDefaults() {
        setTitle();
        setFont();
        setImage();
    }

}
