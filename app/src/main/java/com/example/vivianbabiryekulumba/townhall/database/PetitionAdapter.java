package com.example.vivianbabiryekulumba.townhall.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

import java.util.List;

public class PetitionAdapter extends RecyclerView.Adapter<PetitionAdapter.PetitionViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Petition> petitionsList;

    public PetitionAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PetitionAdapter.PetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_recycler_petiton, parent, false);
        return new PetitionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionAdapter.PetitionViewHolder holder, int position) {
        if(petitionsList != null){
            Petition currentPetition = petitionsList.get(position);
            holder.recycler_petition_tv.setText(currentPetition.getPetition());
        }else{
            holder.recycler_petition_tv.setText(R.string.no_petitions);
        }
    }

    void setPetitionsList(List<Petition> petitions){
        this.petitionsList = petitions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(petitionsList != null){
            return petitionsList.size();
        }
        return 0;
    }

    public class PetitionViewHolder extends RecyclerView.ViewHolder {

        TextView recycler_petition_tv;

        public PetitionViewHolder(View itemView) {
            super(itemView);

            recycler_petition_tv = itemView.findViewById(R.id.recycler_petition_tv);
        }
    }
}
