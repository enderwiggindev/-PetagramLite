package com.example.petagramlite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.petagramlite.adapter.PetAdapter;
import com.example.petagramlite.adapter.ViewPagerAdapter;
import com.example.petagramlite.fragment.ProfileFragment;
import com.example.petagramlite.fragment.RecyclerViewFragment;
import com.example.petagramlite.pojo.Pet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /* Toolbar */
    private Toolbar myToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    /* Array Fragments*/
    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }

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

        myToolbar = (Toolbar) findViewById(R.id.action_bar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager();
        if (myToolbar != null)
            setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_contactus:
                String email = getString(R.string.contact_email);
                String subject = getString(R.string.contact_subject);
                String comment = getString(R.string.contact_comment);
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, comment);
                //emailIntent.setType("message/rfc822");
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                } else {
                    Toast.makeText(this, "Application not found", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "in processing", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_star:
                intent = new Intent(this, MainActivity2.class);
                /*
                liked_names = adapter.getLikedNames();
                liked_ratings = adapter.getLikedRatings();
                liked_photos = adapter.getLikedPhotos();

                intent.putExtra(getResources().getString(R.string.pet_names), liked_names);
                intent.putExtra(getResources().getString(R.string.pet_ratings), liked_ratings);
                intent.putExtra(getResources().getString(R.string.pet_photo), liked_photos);

                 */
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupViewPager(){
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(R.string.home);
        tabLayout.getTabAt(1).setText(R.string.gallery);
        //tabLayout.getTabAt(0).setIcon(R.drawable.home);
        //tabLayout.getTabAt(1).setIcon(R.drawable.gallery);
    }
}