package com.example.parag.bakingapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.example.parag.bakingapp.activities.MainActivity;
import android.support.test.espresso.contrib.RecyclerViewActions;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by parag on 26-11-2017.
 */

@RunWith(AndroidJUnit4.class)
public class RecipeListActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

//    No need to use Idling Resource 'cause Espresso supports AsyncTask and it automatically
//    waits for the task to finish before it can begin testing the UI.

    @Test
    public void clickOnRecyclerViewItem(){
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        onView(withId(R.id.ingredient_label)).check(matches(isDisplayed()));

        onView(withId(R.id.step_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.view_pager))
                .check(matches(isDisplayed()));
    }


}
