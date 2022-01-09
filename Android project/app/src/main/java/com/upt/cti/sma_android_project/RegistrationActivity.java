package com.upt.cti.sma_android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText registerEmail, registerPassword;
    private Button registerButton;
    private TextView questionRegistrationScreen;
    private Toolbar toolbarRegistration;
    private FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();

        questionRegistrationScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

//        if (firebaseAuth.getCurrentUser() != null) {
//            startActivity( new Intent(getApplicationContext(), HomeActivity.class));
//            finish();
//        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String password = registerPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    registerEmail.setError("You need to add an email!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    registerPassword.setError("You need to add an password!");
                    return;
                }

                if (password.length() < 6 ) {
                    registerPassword.setError("Password should contain more than 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent( RegistrationActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            String error = task.getException().toString();
                            Toast.makeText(RegistrationActivity.this, "Registration failed " + error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}