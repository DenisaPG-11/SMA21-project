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

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private TextView questionLoginScreen;
    private Toolbar toolbarLogin;
    private FirebaseAuth firebaseAuth;

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

        firebaseAuth = FirebaseAuth.getInstance();

        setSupportActionBar(toolbarLogin);
        getSupportActionBar().setTitle("Login Screen");

        questionLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    loginEmail.setError("You need to add an email!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    loginPassword.setError("You need to add an password!");
                    return;
                } else {

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent( LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
   //                             finish();
                            }else {
                                String error = task.getException().toString();
                                Toast.makeText(LoginActivity.this, "Login failed " + error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}