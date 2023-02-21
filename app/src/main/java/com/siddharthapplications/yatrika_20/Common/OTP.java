package com.siddharthapplications.yatrika_20.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.siddharthapplications.yatrika_20.R;

public class OTP extends AppCompatActivity {

    TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        String name = getIntent().getStringExtra("_name");
        String phoneNumber = getIntent().getStringExtra("_phoneNumber");
        String email = getIntent().getStringExtra("_email");
        String username = getIntent().getStringExtra("_username");
        String password = getIntent().getStringExtra("_pass");

        number = findViewById(R.id.phoneNumber);
        number.setText(phoneNumber);

        sendVerificationCodeToUser(phoneNumber);

    }

    private void sendVerificationCodeToUser(String phoneNumber) {

    }
}