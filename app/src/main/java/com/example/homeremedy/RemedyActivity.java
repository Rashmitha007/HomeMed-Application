package com.example.homeremedy;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class RemedyActivity extends AppCompatActivity {
    private TextView diseaseNameTextView;
    private ListView remediesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedy);

        // Get the disease name from intent or wherever you're storing it
        String diseaseName = "Your Disease Name";

        // Get the list of remedies and their summaries
        ArrayList<Remedy> remedies = getRemedies(); // Replace with your own method to retrieve remedies

        // Initialize views

        diseaseNameTextView = findViewById(R.id.diseaseNameTextView);
        remediesListView = findViewById(R.id.remediesListView);

        // Set disease name
        diseaseNameTextView.setText(diseaseName);

        // Create adapter for remedies

        RemedyAdapter remediesAdapter = new RemedyAdapter(this, remedies);

        // Set adapter on ListView
        remediesListView.setAdapter(remediesAdapter);;
    }

    private ArrayList<Remedy> getRemedies() {
        // Replace with your own logic to retrieve remedies
        ArrayList<Remedy> remedies = new ArrayList<>();
        remedies.add(new Remedy("Remedy 1", "Summary 1"));
        remedies.add(new Remedy("Remedy 2", "Summary 2"));
        remedies.add(new Remedy("Remedy 3", "Summary 3"));

        return remedies;
    }
}
