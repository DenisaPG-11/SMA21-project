package com.upt.cti.sma_android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private TextView questionLoginScreen;
    private Toolbar toolbarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.login_email_field);
        loginPassword =  findViewById(R.id.login_password_field);
        questionLoginScreen =  findViewById(R.id.login_page_register);
        loginButton = findViewById(R.id.login_button);
        toolbarLogin =  findViewById(R.id.login_toolbar);

        setSupportActionBar(toolbarLogin);
        getSupportActionBar().setTitle("Login Screen");

        questionLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}