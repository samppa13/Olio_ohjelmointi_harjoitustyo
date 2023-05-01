package com.example.olio_ohjelmointi_harjoitustyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.imageView.setImageResource(lutemons.get(position).getImage());
        holder.nameTextView.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.attackTextView.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.defenceTextView.setText("Puolustus: " + lutemons.get(position).getDefense());
        holder.healthTextView.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.experienceTextView.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.winsTextView.setText("Voitot: " + lutemons.get(position).getWins());
        holder.lossesTextView.setText("Tappiot: " + lutemons.get(position).getLosses());
        holder.trainingDaysTextView.setText("Treenipäivät: " + lutemons.get(position).getTrainingDays());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
