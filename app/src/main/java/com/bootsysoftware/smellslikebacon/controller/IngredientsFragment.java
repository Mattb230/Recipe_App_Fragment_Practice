package com.bootsysoftware.smellslikebacon.controller;

import com.bootsysoftware.smellslikebacon.model.Recipes;

/**
 * Created by Matthew Boydston on 9/27/2016.
 */
public class IngredientsFragment extends CheckboxesFragment {

    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
