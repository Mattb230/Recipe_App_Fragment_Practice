package com.bootsysoftware.smellslikebacon.controller;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bootsysoftware.smellslikebacon.R;

/**
 * Created by Matthew Boydston on 9/22/2016.
 */
public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Create View variable and set it to the inflated view we want to use
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        return view;
    }
}
