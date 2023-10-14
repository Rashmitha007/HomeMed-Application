package com.example.homeremedy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_signin extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button2);

        firebaseAuth = FirebaseAuth.getInstance();

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(em)) {
                    email.setError("Please enter an email");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Please enter your password");
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(em, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(activity_signin.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), homeactivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(activity_signin.this, "Authentication failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(em)) {
                    email.setError("Please enter an email");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Please enter your password");
                    return;
                }

                if (pass.length() < 8) {
                    password.setError("Password must be at least 8 characters");
                    return;
                }

                // Password validation using regex
                String regex = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
                if (!pass.matches(regex)) {
                    password.setError("Password must contain at least one uppercase letter and one special character (@#$%^&+=)");
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(em, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(activity_signin.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), homeactivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(activity_signin.this, "Authentication failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
