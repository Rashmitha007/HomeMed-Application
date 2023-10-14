package com.example.homeremedy;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyRemedy extends AppCompatActivity {
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    EditText input;
    ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_remedy);


        //getSupportActionBar().setTitle("My Remedy");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        input=findViewById(R.id.editTextTextMultiLine);
        enter=findViewById(R.id.enter);
        listView=findViewById(R.id.list_item);
        items=new ArrayList<>();
        //items.add("Acne \n Mix one tbsp of tumeric with honey and apply on your face.wash with cold water");
        //items.add("Cough \n Mix one tbsp of tumeric with honey and apply on your face.wash with cold water");

        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=input.getText().toString();
                if(text==null||text.length()==0){
                    Toast.makeText(MyRemedy.this, "Enter remedy", Toast.LENGTH_SHORT).show();
                }
                else{
                    addItem(text);
                    input.setText(""); //after adding item again set blank
                    makeToast("your remedy is sucessfully added"+text);
                }
            }
        });


    }
    public void addItem(String item){
        items.add(item);
        listView.setAdapter(adapter);
    }
    Toast t;
    private void makeToast(String s)
    {
        if(t!=null) t.cancel();
        t=Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
        t.show();
    }
}