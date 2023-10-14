package com.example.homeremedy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class signup_Activity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText email;
    EditText phone;
    Button Register;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        getSupportActionBar().setTitle("Sign Up");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
       username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        phone = (EditText) findViewById(R.id.editTextPhone);
        Register = (Button) findViewById(R.id.button);
        fAuth = FirebaseAuth.getInstance();

        /*Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String em = email.getText().toString();
                String ph = phone.getText().toString();


                if (TextUtils.isEmpty(em)) {
                    email.setError("Email is Required.");
                    return;

                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Password is Required");
                    return;

                }
                if (password.length() < 6) {
                    password.setError("Password Must be >= 6 Characters");

                }

                fAuth.createUserWithEmailAndPassword(em,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup_Activity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            FirebaseUser firebaseUser = fAuth.getCurrentUser();
                            //user data to firebase
                            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(user, pass, em, ph);

                            //extracting user reference from database for registered users
                            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("registered users");
                            referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {


                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(signup_Activity.this, "user registered successfully.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(signup_Activity.this, MainActivity.class));
                                    } else {
                                        Toast.makeText(signup_Activity.this, "registeraton failed", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });

                        } else {
                            Toast.makeText(signup_Activity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });*/
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String em = email.getText().toString();
                String ph = phone.getText().toString();

                if (TextUtils.isEmpty(em)) {
                    email.setError("Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    password.setError("Password is required.");
                    return;
                }

                if (password.length() < 8) {
                    password.setError("Password must be at least 8 characters.");
                    return;
                }

                // Password validation using regex
                String regex = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
                if (!pass.matches(regex)) {
                    password.setError("Password must contain at least one uppercase letter and one special character (@#$%^&+=).");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup_Activity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            FirebaseUser firebaseUser = fAuth.getCurrentUser();
                            // User data to Firebase
                            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(user, pass, em, ph);

                            // Extracting user reference from the database for registered users
                            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("registered users");
                            referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(signup_Activity.this, "User registered successfully.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(signup_Activity.this, MainActivity.class));
                                    } else {
                                        Toast.makeText(signup_Activity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(signup_Activity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}










