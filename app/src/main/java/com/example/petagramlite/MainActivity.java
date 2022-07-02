package com.example.petagramlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* Adapter */
    String [] liked_names;
    String [] liked_ratings;
    int [] liked_photos;
    PetAdapter adapter;

    /* Reclycler view */
    ArrayList<Pet> pets;
    RecyclerView listPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        try {

            listPets =  (RecyclerView) findViewById(R.id.recycler_view_pets);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            listPets.setLayoutManager(llm);
            initPetList();
            initAdapter();
        } catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_star:
                liked_names = adapter.getLikedNames();
                liked_ratings = adapter.getLikedRatings();
                liked_photos = adapter.getLikedPhotos();
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra(getResources().getString(R.string.pet_names), liked_names);
                intent.putExtra(getResources().getString(R.string.pet_ratings), liked_ratings);
                intent.putExtra(getResources().getString(R.string.pet_photo), liked_photos);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void initAdapter(){
        adapter = new PetAdapter(pets, this);
        listPets.setAdapter(adapter);
    }
    public void initPetList(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Bella", "10", R.drawable.dog1));
        pets.add(new Pet("Luna", "50", R.drawable.dog2));
        pets.add(new Pet("Charlie", "12", R.drawable.dog3));
        pets.add(new Pet("Lucy", "13", R.drawable.dog4));
        pets.add(new Pet("Cooper", "42", R.drawable.dog5));
        pets.add(new Pet("Max", "20", R.drawable.dog6));
    }
}