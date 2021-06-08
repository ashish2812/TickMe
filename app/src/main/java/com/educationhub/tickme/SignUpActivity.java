package com.educationhub.tickme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signIn(View view) {
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
        finish();
    }

    public void signUp(View view) {
        startActivity(new Intent(getApplicationContext(), AuthenticationActivity.class));
        finish();
    }
}