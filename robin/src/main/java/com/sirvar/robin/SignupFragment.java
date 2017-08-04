package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignupFragment extends Fragment {

    private TextView title;
    private TextView login;
    private ImageView logo;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private TextInputLayout nameWrapper;
    private TextInputLayout emailWrapper;
    private TextInputLayout passwordWrapper;
    private TextInputLayout confirmPasswordWrapper;
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
        login = (TextView) view.findViewById(R.id.login);
        logo = (ImageView) view.findViewById(R.id.logo);
        name = (EditText) view.findViewById(R.id.name);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        confirmPassword = (EditText) view.findViewById(R.id.confirm_password);
        nameWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_name);
        emailWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_email);
        passwordWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_password);
        confirmPasswordWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_confirm_password);
        submit = (Button) view.findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).startLoginFragment();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fieldsFilled()) {
                    ((RobinActivity) getActivity()).onSignup(name.getText().toString(), email.getText().toString(), password.getText().toString());
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Some information is missing.", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
    protected void setFont(Typeface typeface) {
        this.typeface = typeface;
    }

    /**
     * Set custom font for all Views
     */
    private void setFont() {
        title.setTypeface(typeface);
        login.setTypeface(typeface);
        name.setTypeface(typeface);
        email.setTypeface(typeface);
        password.setTypeface(typeface);
        confirmPassword.setTypeface(typeface);
        nameWrapper.setTypeface(typeface);
        emailWrapper.setTypeface(typeface);
        passwordWrapper.setTypeface(typeface);
        confirmPasswordWrapper.setTypeface(typeface);
        submit.setTypeface(typeface);
    }

    private boolean fieldsFilled() {
        return (!(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) && (password.getText().toString().equals(confirmPassword.getText().toString())));
    }

    private void setDefaults() {
        setTitle();
        setFont();
        setImage();
    }
}
