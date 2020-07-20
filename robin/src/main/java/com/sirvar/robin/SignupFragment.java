package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignupFragment extends Fragment {

    private RelativeLayout layout;
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
        title = view.findViewById(R.id.title);
        login = view.findViewById(R.id.login);
        logo = view.findViewById(R.id.logo);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        confirmPassword = view.findViewById(R.id.confirm_password);
        nameWrapper = view.findViewById(R.id.wrapper_name);
        emailWrapper = view.findViewById(R.id.wrapper_email);
        passwordWrapper = view.findViewById(R.id.wrapper_password);
        confirmPasswordWrapper = view.findViewById(R.id.wrapper_confirm_password);
        submit = view.findViewById(R.id.submit);
        layout=view.findViewById(R.id.signup_layout);



        ((RobinActivity) getActivity()).onSignupFragmentCreated(this);

        login.setOnClickListener(v -> ((RobinActivity) getActivity()).startLoginFragment());

        submit.setOnClickListener(v -> {
            if (fieldsFilled() && passwordsMatch(password,confirmPassword)) {

                ((RobinActivity) getActivity()).onSignup(name.getText().toString(), email.getText().toString(), password.getText().toString());
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Signup Failed.", Toast.LENGTH_SHORT).show();
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


    /**
     *
     * @param edit
     * @return true if a field is {@link android.view.View#VISIBLE} and filled out or if it's
     * not visible
     */
    private boolean isFieldFilled(EditText edit) {

        return edit.getVisibility() != View.VISIBLE || (edit.getText().toString() != null && !edit.getText().toString().trim().isEmpty());
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
        }
        return true;

    }

    private boolean passwordsMatch(EditText password, EditText confirmPassword) {

        return password.getVisibility() != View.VISIBLE || password.getText().toString().equals(confirmPassword.getText().toString());

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
    public void setNameField(int visibility, @Nullable String hint)
    {
        name.setVisibility(visibility);

        if (hint!=null)
        {
            nameWrapper.setHint(hint);
            name.setHint(hint);
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
        confirmPassword.setVisibility(visibility);


        if (hint!=null)
        {
            passwordWrapper.setHint(hint);
            password.setHint(hint);
        }
    }



}
