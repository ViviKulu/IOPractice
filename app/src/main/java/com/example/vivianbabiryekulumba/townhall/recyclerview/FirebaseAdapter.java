package com.example.vivianbabiryekulumba.townhall.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class FirebaseAdapter extends FirebaseRecyclerAdapter{

    public FirebaseAdapter(Class modelClass, int modelLayout, Class viewHolderClass, DatabaseReference ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(RecyclerView.ViewHolder viewHolder, Object model, int position) {

    }
}
