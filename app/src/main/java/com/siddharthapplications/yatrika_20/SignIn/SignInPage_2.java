package com.siddharthapplications.yatrika_20.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.siddharthapplications.yatrika_20.Common.OTP;
import com.siddharthapplications.yatrika_20.R;

public class SignInPage_2 extends AppCompatActivity {

    Button back, next;
    TextInputLayout username, pass, cPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page2);

        String name = getIntent().getStringExtra("_name");
        String phoneNumber = getIntent().getStringExtra("_phoneNumber");
        String email = getIntent().getStringExtra("_email");

        username = findViewById(R.id.userName);
        pass = findViewById(R.id.password);
        cPass = findViewById(R.id.confirmPassword);

        next = findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _username = username.getEditText().getText().toString();
                String _pass = pass.getEditText().getText().toString();

                if( !validateusername() | !validatePassword() | !validateCPassword()) {
                    return;
                }
                Intent intent = new Intent(SignInPage_2.this, OTP.class);
                intent.putExtra("_name", name);
                intent.putExtra("_phoneNumber", phoneNumber);
                intent.putExtra("_email", email);
                intent.putExtra("_username", _username);
                intent.putExtra("_pass", _pass);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInPage_2.this, SignInPage.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private boolean validateusername() {
        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field cannot be empty!");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too big!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("No white spaces allowed!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = pass.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +
                //"(?=.*[a-z])" +
                //"(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{7,}" +
                "$";
        if (val.isEmpty()) {
            pass.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            pass.setError("Password must contain\natleast 1 special character\nno white space\nmust be 7 character or more!");
            return false;
        } else {
            pass.setError(null);
            pass.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateCPassword() {
        String val = pass.getEditText().getText().toString().trim();
        String valC = cPass.getEditText().getText().toString().trim();
        if(val.equals(valC)) {
            return true;
        } else {
            cPass.setError("Does not match password!");
            return false;
        }
    }
}