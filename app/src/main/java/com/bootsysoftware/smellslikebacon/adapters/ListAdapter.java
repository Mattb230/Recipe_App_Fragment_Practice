package com.bootsysoftware.smellslikebacon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bootsysoftware.smellslikebacon.controller.ListFragment;
import com.bootsysoftware.smellslikebacon.R;
import com.bootsysoftware.smellslikebacon.model.Recipes;

/**
 * Created by Matthew Boydston on 9/22/2016.
 */
public class ListAdapter extends RecyclerView.Adapter {
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate view that the adapter will use the show the list item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    // Update the view and the Viewholder to reflect which position it is in the screen
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).BindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }
    // View Holder class. Want to take action when an item is clicked, so I needed to implement View.OnClickListener
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            // Set the view holder as the itemViews onclickListener
            itemView.setOnClickListener(this);
        }

        public void BindView(int position){
            mIndex = position;
            //Update views to display the right recipe and image
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            //call the method in the interface we made
            mListener.onListRecipeSelected(mIndex);
        }
    }
} //end class
