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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPasswordFragment extends Fragment {

    private TextView title;
    private TextView login;
    private ImageView logo;
    private EditText email;
    private TextInputLayout emailWrapper;
    private Button submit;
    private Typeface typeface;
    private String titleText;
    private Drawable logoDrawable;
    private Bitmap logoBitmap;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        // Initialize views
        title = (TextView) view.findViewById(R.id.title);
        login = (TextView) view.findViewById(R.id.login);
        logo = (ImageView) view.findViewById(R.id.logo);
        email = (EditText) view.findViewById(R.id.email);
        emailWrapper = (TextInputLayout) view.findViewById(R.id.wrapper_email);
        submit = (Button) view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).onForgotPassword(email.getText().toString());
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RobinActivity) getActivity()).startLoginFragment();
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
    public void setFont(Typeface typeface) {
        this.typeface = typeface;
    }

    /**
     * Set custom font for all Views
     */
    private void setFont() {
        title.setTypeface(typeface);
        login.setTypeface(typeface);
        email.setTypeface(typeface);
        emailWrapper.setTypeface(typeface);
        submit.setTypeface(typeface);
    }

    private void setDefaults() {
        setTitle();
        setImage();
        setFont();
    }
}
