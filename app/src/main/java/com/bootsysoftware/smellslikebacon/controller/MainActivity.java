package com.bootsysoftware.smellslikebacon.controller;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bootsysoftware.smellslikebacon.R;
import com.bootsysoftware.smellslikebacon.model.Recipes;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentByTag(LIST_FRAGMENT);

        if(savedFragment == null){
            ListFragment fragment = new ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Add fragment, arguments are the placeHolder view in activity_main, the fragment we just
            // created, and the key we want to use to find this fragment in the future
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            // Need a .commit() for it to work
            fragmentTransaction.commit();
        }
    }

    // Called when a recipe in the fragment is selected
    @Override
    public void onListRecipeSelected(int index) {

        // When a list item is clicked, create a new ViewPagerFragment and replace it with the current fragment
        ViewPagerFragment fragment = new ViewPagerFragment();
        // Bundle to store key and index
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        // Set bundle as arguments for our fragment
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        // Without this, app would close when user clicked the "back" button. Can pass null since
        // app just goes back to the main activity when the back button is clicked
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
