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

public class RegistrationActivity extends AppCompatActivity {

    private EditText registerEmail, registerPassword;
    private Button registerButton;
    private TextView questionRegistrationScreen;
    private Toolbar toolbarRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        registerEmail = findViewById(R.id.register_email_field);
        registerPassword =  findViewById(R.id.register_password_field);
        questionRegistrationScreen =  findViewById(R.id.register_page_login);
        registerButton = findViewById(R.id.register_button);
        toolbarRegistration =  findViewById(R.id.register_toolbar);

        setSupportActionBar(toolbarRegistration);
        getSupportActionBar().setTitle("Registration Screen");

        questionRegistrationScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}