package com.siddharthapplications.yatrika_20.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siddharthapplications.yatrika_20.R;
import com.siddharthapplications.yatrika_20.SignIn.SignInPage;

public class LoginActivity extends AppCompatActivity {

    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signIn = (Button) findViewById(R.id.signin_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignInPage.class);
                startActivity(intent);
            }
        });
    }
}