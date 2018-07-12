package com.example.vivianbabiryekulumba.townhall.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

import java.util.List;

import static android.content.ContentValues.TAG;

public class PetitionAdapter extends RecyclerView.Adapter<PetitionViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Petition> petitionsList;

    public PetitionAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_recycler_petiton, parent, false);
        return new PetitionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionViewHolder holder, int position) {
        holder.onBind(petitionsList.get(position));
        Log.d(TAG, "onBindViewHolder: ran" + petitionsList.size());
    }

    public void setPetitionsList(List<Petition> petitions){
        this.petitionsList = petitions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (petitionsList != null) {
            return petitionsList.size();
        } else {
            return 0;
        }
    }

}
