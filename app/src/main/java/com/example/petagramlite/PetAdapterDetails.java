package com.example.petagramlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class PetAdapterDetails extends RecyclerView.Adapter<PetAdapterDetails.PetViewHolder> {
    // putExtra values
    String[] liked_names;
    String[] liked_ratings;
    int[] liked_photos;
    int index, size;

    ArrayList<Pet> pets;
    Activity activity;

    public PetAdapterDetails(ArrayList<Pet> pets, Activity activity){
        this.pets = pets;
        this.activity = activity;
        // default size = 3
        this.size = 3;
        this.liked_names = new String[this.size];
        this.liked_ratings = new String[this.size];
        this.liked_photos = new int[this.size];
        this.index = 0;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet_details, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        final Pet p = pets.get(position);
        holder.image_pet.setImageResource(p.getPhoto());
        holder.text_view_name.setText(p.getName());
        holder.pet_rating.setText(p.getRating());
    }

    public String[] getLikedNames(){
        return this.liked_names;
    }
    public String[] getLikedRatings(){
        return this.liked_ratings;
    }
    public int[] getLikedPhotos(){
        return this.liked_photos;
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView image_pet;
        private MaterialTextView text_view_name;
        private MaterialTextView pet_rating;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            image_pet = (AppCompatImageView) itemView.findViewById(R.id.image_pet);
            text_view_name = (MaterialTextView) itemView.findViewById(R.id.text_view_name);
            pet_rating = (MaterialTextView) itemView.findViewById(R.id.pet_rating);
        }
    }

}
