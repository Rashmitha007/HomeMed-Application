package com.example.homeremedy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class quesfeed extends AppCompatActivity {
    EditText name,email,message;
    Button send,check;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesfeed);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("Feedback");

        name=findViewById(R.id.editTextTextPersonName2);
        email=findViewById(R.id.editTextTextPersonName3);
        message=findViewById(R.id.editTextTextPersonName4);

        send=findViewById(R.id.button4);
        check=findViewById(R.id.button5);
        fAuth = FirebaseAuth.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check.setEnabled(true);
                String nam = name.getText().toString();
                String em = email.getText().toString();
                String msg = message.getText().toString();

                FirebaseUser firebaseUser = fAuth.getCurrentUser();

                FeedDetails feedDetails = new FeedDetails(nam,em,msg);
                DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Feedback");
                referenceProfile.child(firebaseUser.getUid()).setValue(feedDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(nam.isEmpty()||em.isEmpty()||msg.isEmpty())
                        {
                            Toast.makeText(quesfeed.this, "All fields required", Toast.LENGTH_SHORT).show();
                            send.setEnabled(false);
                        }
                        else
                        {
                            Toast.makeText(quesfeed.this,"thank you for feedback", Toast.LENGTH_SHORT).show();
                            send.setEnabled(true);

                        }
                        Toast.makeText(quesfeed.this,"your feedback was sent",Toast.LENGTH_SHORT).show();

                        check.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                new AlertDialog.Builder(quesfeed.this)
                                        .setTitle("Sended Details")
                                        .setMessage("Name-"+nam+"\n\nEmail-"+em+"\n\nMessage-"+msg)
                                        .show();


                            }
                        });
                    }
                });
            }
        });
    }
}