package com.bootsysoftware.smellslikebacon.controller;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bootsysoftware.smellslikebacon.R;
import com.bootsysoftware.smellslikebacon.model.Recipes;

/**
 * Created by Matthew Boydston on 9/22/2016.
 */
public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX = "recipe_index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        //Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();
        getActivity().setTitle(Recipes.names[index]);

        // Create View variable and set it to the inflated view we want to use
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        final DirectionsFragment directionsFragment = new DirectionsFragment();

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                // if position == 0 return ingredients, else return directions
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                // if position == 0 return ingredients, else return directions
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
