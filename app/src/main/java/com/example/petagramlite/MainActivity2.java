package com.example.petagramlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.petagramlite.adapter.PetAdapterDetails;
import com.example.petagramlite.pojo.Pet;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    String [] liked_names;
    String [] liked_ratings;
    int [] liked_photos;

    /* Adapter */
    PetAdapterDetails adapter;

    /* Reclycler view */
    ArrayList<Pet> pets;
    RecyclerView listPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_bar);
        if (myToolbar != null)
            setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        Bundle params = getIntent().getExtras();
        liked_names = params.getStringArray(getResources().getString(R.string.pet_names));
        liked_ratings = params.getStringArray(getResources().getString(R.string.pet_ratings));
        liked_photos = params.getIntArray(getResources().getString(R.string.pet_photo));

        try {
            listPets =  (RecyclerView) findViewById(R.id.recycler_view_pets2);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            listPets.setLayoutManager(llm);
            initPetList();
            initAdapter();
        } catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
*/

    }
    public void initAdapter(){
        adapter = new PetAdapterDetails(pets, this);
        listPets.setAdapter(adapter);
    }

    public void initPetList(){
        pets = new ArrayList<Pet>();
        for (int i = 0; i < liked_names.length; i++) {
            if (liked_names[i] != null)
                pets.add(new Pet(liked_names[i], liked_ratings[i], liked_photos[i]));
        }
    }
}