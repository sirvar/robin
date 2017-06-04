package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignupFragment extends Fragment {

    private TextView title;
    private TextView signup;
    private TextView forgotPassword;
    private ImageView logo;
    private EditText email;
    private EditText password;
    private TextInputLayout emailWrapper;
    private TextInputLayout passwordWrapper;
    private Button submit;

    private Typeface typeface;
    private String titleText;
    private Drawable logoDrawable;
    private Bitmap logoBitmap;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

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

        return view;
    }

}
