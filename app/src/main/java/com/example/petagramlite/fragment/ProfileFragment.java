package com.example.petagramlite.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.petagramlite.R;
import com.example.petagramlite.adapter.PetAdapterDetails;
import com.example.petagramlite.pojo.Pet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<Pet> pets;
    RecyclerView listPets;
    PetAdapterDetails adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_profile, container, false);
        //listPets =  (GridView) v.findViewById(R.id.grid_layout_pets);
        //GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listPets.setLayoutManager(llm);
        //initPetList();
        //initAdapter();
        //return v;
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        listPets =  (RecyclerView) v.findViewById(R.id.recycler_view_profile);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPets.setLayoutManager(llm);
        initPetList();
        initAdapter();
        return v;

        //return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void initAdapter(){
        adapter = new PetAdapterDetails(pets, getActivity());
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