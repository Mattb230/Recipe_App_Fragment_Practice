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
public abstract class CheckboxesFragment extends Fragment {
    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    private CheckBox[] mCheckboxes;
    private String[] contents;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkboxesLayout);
        String[] contents = getContents(index);

        mCheckboxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[mCheckboxes.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        setupCheckBoxes(contents, linearLayout, checkedBoxes);

        return view;
    }

    private void setupCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes){
        int i = 0;
        for(String content : contents){
            mCheckboxes[i] = new CheckBox(getActivity());
            mCheckboxes[i].setPadding(8, 16, 8, 16);
            mCheckboxes[i].setTextSize(20f);
            mCheckboxes[i].setText(content);
            container.addView(mCheckboxes[i]);
            if(checkedBoxes[i]){
                mCheckboxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckboxes = new boolean[mCheckboxes.length];
        int i = 0;
        for(CheckBox checkbox : mCheckboxes){
            stateOfCheckboxes[i] = checkbox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckboxes);
        super.onSaveInstanceState(outState);
    }

    // Child classes will override this to set their own contents (Ingredients or Directions)
    public abstract String[] getContents(int index);
}
