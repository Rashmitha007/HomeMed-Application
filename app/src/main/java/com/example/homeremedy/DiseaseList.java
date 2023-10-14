package com.example.homeremedy;

//public class DiseaseList {
//}


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class DiseaseList extends AppCompatActivity {
    private ArrayList<Disease> diseases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("Home Activity");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference diseasesRef = db.collection("diseases");
        diseasesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                diseases = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    String name = document.getString("name");
                    String imageUrl = document.getString("imageUrl");
                    // Assuming you have fields "name" and "imageUrl" in your Firestore document

                    diseases.add(new Disease(imageUrl, name));
                }

                // Sort the diseases alphabetically
                Collections.sort(diseases, (d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

                // Create the adapter
                DiseaseAdapter adapter = new DiseaseAdapter(this, diseases);

                // Get the ListView and set the adapter
                ListView listView = findViewById(R.id.diseaseList);
                listView.setAdapter((ListAdapter) adapter);
            } else {
                // Handle error
            }
        });

        diseases = new ArrayList<>();
        diseases.add(new Disease(R.drawable.anxiety, "Anxiety"));
        diseases.add(new Disease(R.drawable.asthma, "Asthma/wheezing"));
        diseases.add(new Disease(R.drawable.acidity, "Acidity"));
        diseases.add(new Disease(R.drawable.badbreath, "Bad Breath"));
        diseases.add(new Disease(R.drawable.acne, "Acne"));
        diseases.add(new Disease(R.drawable.allergy, "Allergy"));
        // Add more diseases here

        // Sort the diseases alphabetically
        Collections.sort(diseases, (d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

        // Create the adapter
        DiseaseAdapter adapter = new DiseaseAdapter(this, diseases);

        // Get the ListView and set the adapter
        ListView listView = findViewById(R.id.diseaseList);
        listView.setAdapter((ListAdapter) adapter);

        // Set item click listener to navigate to the remedy page
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Disease selectedDisease = Disease.get(position);
                //Intent intent = new Intent(DiseaseList.this, RemedyActivity.class);
                Intent intent = new Intent(getApplicationContext(), RemedyActivity.class);
                intent.putExtra("diseaseName", selectedDisease.getName());
                startActivity(intent);
            }
        });
    }
}
