package com.example.homeremedy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.homeremedy.R;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.homeremedy.R;

import java.util.ArrayList;

public class RemedyAdapter extends ArrayAdapter<Remedy> {

    public RemedyAdapter(Context context, ArrayList<Remedy> remedies) {
        super(context, 0, remedies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_remedy, parent, false);
        }

        Remedy currentRemedy = getItem(position);

        TextView remedyNameTextView = listItemView.findViewById(R.id.remedyNameTextView);
        remedyNameTextView.setText(currentRemedy.getName());

        TextView remedySummaryTextView = listItemView.findViewById(R.id.remedySummaryTextView);
        remedySummaryTextView.setText(currentRemedy.getSummary());

        return listItemView;
    }
}


