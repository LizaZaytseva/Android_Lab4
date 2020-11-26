package com.example.lab4_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class AdaptClass extends RecyclerView.Adapter<AdaptClass.ViewHolder> {

    private ArrayList<ItemClass> items;
    private LayoutInflater inflater;

    AdaptClass(Context context, ArrayList<ItemClass> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AdaptClass.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptClass.ViewHolder holder, int position) {
        int pos = position % items.size();
        ItemClass item = items.get(position);
        holder.author.setText(item.getAuthor());
        holder.title.setText(item.getTitle());
        holder.journal.setText(item.getJournal());
        holder.year.setText(item.getYear());
        holder.pages.setText(item.getPages());
    }

    @Override
    public int getItemCount() {
        return items.size();
        //return Integer.MAX_VALUE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView author, title, journal, year, pages;
        ViewHolder(View view){
            super(view);
            author= (TextView) view.findViewById(R.id.author);
            title= (TextView) view.findViewById(R.id.title);
            journal= (TextView) view.findViewById(R.id.journal);
            year= (TextView) view.findViewById(R.id.year);
            pages= (TextView) view.findViewById(R.id.pages);
        }
}
}
