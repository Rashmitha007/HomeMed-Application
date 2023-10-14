package com.example.homeremedy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

        public class MainActivity extends AppCompatActivity {
            Button login;
            Button create_acc;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                create_acc = findViewById(R.id.create_acc);
                login=findViewById(R.id.button3);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,activity_signin.class);

                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();

                    }
                });
                create_acc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "your account will be created soon", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, signup_Activity.class);
                        startActivity(intent);
                    }
                });

            }
        }


