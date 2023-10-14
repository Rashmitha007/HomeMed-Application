package com.example.homeremedy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DiseaseAdapter extends ArrayAdapter<Disease> {
    public DiseaseAdapter(Context context, ArrayList<Disease> diseases) {
        super(context, 0, diseases);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Disease currentDisease = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.diseaseImage);
        imageView.setImageResource(currentDisease.getImageResId());

        TextView nameTextView = listItemView.findViewById(R.id.diseaseName);
        nameTextView.setText(currentDisease.getName());

        ImageView arrowImageView = listItemView.findViewById(R.id.arrowImage);
        arrowImageView.setImageResource(R.drawable.arrow);

        return listItemView;
    }
}

