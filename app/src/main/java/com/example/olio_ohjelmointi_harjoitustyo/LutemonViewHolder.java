package com.example.olio_ohjelmointi_harjoitustyo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    TextView nameTextView, attackTextView, defenceTextView, healthTextView, experienceTextView;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        attackTextView = itemView.findViewById(R.id.attackTextView);
        defenceTextView = itemView.findViewById(R.id.defenceTextView);
        healthTextView = itemView.findViewById(R.id.healthTextView);
        experienceTextView = itemView.findViewById(R.id.experienceTextView);
    }
}
