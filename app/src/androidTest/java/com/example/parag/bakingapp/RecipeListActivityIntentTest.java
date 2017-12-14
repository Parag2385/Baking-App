package com.example.parag.bakingapp;

import android.support.test.runner.AndroidJUnit4;

import com.example.parag.bakingapp.activities.MainActivity;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by parag on 26-11-2017.
 */
@RunWith(AndroidJUnit4.class)
public class RecipeListActivityIntentTest {

    private static final String EXTRA_RECIPE_ID = "id";
    private static final int DEFAULT_RECIPE_ID = 1;

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickOnRecyclerViewItem_runRecipeStepsIntent(){
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        intended(
                hasExtra(EXTRA_RECIPE_ID,DEFAULT_RECIPE_ID)
        );
    }
}
