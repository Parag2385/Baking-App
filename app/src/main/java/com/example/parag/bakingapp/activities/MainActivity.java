package com.example.parag.bakingapp.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.parag.bakingapp.R;
import com.example.parag.bakingapp.fragments.RecipeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecipeFragment();
    }
    private void initRecipeFragment(){
        RecipeFragment rf = new RecipeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, rf, RecipeFragment.class.getSimpleName());
        ft.commit();
    }
}
