package com.bootsysoftware.smellslikebacon.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.bootsysoftware.smellslikebacon.R;
import com.bootsysoftware.smellslikebacon.model.Recipes;

/**
 * Created by Matthew Boydston on 9/22/2016.
 */
public class IngredientsFragment extends Fragment {
    private CheckBox mCheckboxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientsLayout);

        // Get ingredients at the given index, and put them into an array using ` as delimiter
        String[] ingredients = Recipes.ingredients[index].split("`");
        setupCheckBoxes(ingredients, linearLayout);


        return view;
    }

    private void setupCheckBoxes(String[] ingredients, ViewGroup container){
        for(String ingredient : ingredients){
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8, 16, 8, 16);
            checkBox.setTextSize(20f);
            checkBox.setText(ingredient);
            container.addView(checkBox);
        }
    }
}
