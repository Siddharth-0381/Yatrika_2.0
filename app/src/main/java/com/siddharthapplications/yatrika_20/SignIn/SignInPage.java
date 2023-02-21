package com.siddharthapplications.yatrika_20.SignIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.siddharthapplications.yatrika_20.Common.LoginActivity;
import com.siddharthapplications.yatrika_20.R;

public class SignInPage extends AppCompatActivity {

    Button next, back;
    TextInputLayout name, phoneNumber, email;
    CountryCodePicker countryCodePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        name = findViewById(R.id.fullName);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
        countryCodePicker = findViewById(R.id.countryCode);

        next = (Button) findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validatename() | !validateEmailId()) {
                    return;
                }
                String _name = name.getEditText().getText().toString();
                String _email = email.getEditText().getText().toString();
                String number = phoneNumber.getEditText().getText().toString();
                String _phoneNumber = "+" + countryCodePicker.getSelectedCountryCode() + number;

                Intent intent = new Intent(SignInPage.this, SignInPage_2.class);
                intent.putExtra("_name", _name);
                intent.putExtra("_emailID", _email);
                intent.putExtra("_phoneNumber", _phoneNumber);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInPage.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean validatename() {
        String val = name.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            name.setError("Field cannot be empty!");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmailId() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0_9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }
}