package com.example.parag.bakingapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.parag.bakingapp.R;
import com.example.parag.bakingapp.fragments.RecipeFragment;
import com.example.parag.bakingapp.fragments.StepsListFragment;

import butterknife.BindBool;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecipeStepsActivity extends AppCompatActivity {

    private String sRecipe;
    private static final String EXTRA_RECIPE_NAME = "current_recipe";
    private static final String EXTRA_RECIPE_ID = "id";
    private static final int DEFAULT_RECIPE_ID = 1;


    @BindBool(R.bool.two_pane_mode)
    boolean twoPaneMode;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);
        unbinder = ButterKnife.bind(this);
        if (getIntent() != null) {
            int id = getIntent().getIntExtra(EXTRA_RECIPE_ID,DEFAULT_RECIPE_ID);
            sRecipe = getIntent().getExtras().getString("recipe");
            String title = getIntent().getExtras().getString(EXTRA_RECIPE_NAME);
            setTitle(title);
        }

        if (twoPaneMode) {
            init(savedInstanceState, sRecipe);

        } else {
            init(savedInstanceState, sRecipe);

        }
    }

    private void init(Bundle savedInstanceState, String recipe) {
        if (savedInstanceState == null) {
            StepsListFragment slf = StepsListFragment.newInstance(recipe, twoPaneMode);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, slf, RecipeFragment.class.getSimpleName());
            ft.commit();
        }
    }

}
