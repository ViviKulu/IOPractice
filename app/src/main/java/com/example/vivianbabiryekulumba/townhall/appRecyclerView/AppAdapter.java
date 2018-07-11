package com.example.vivianbabiryekulumba.townhall.appRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 7/9/18.
 */

public class AppAdapter extends RecyclerView.Adapter {
    private ArrayList<ApplicationPOJO> applicationDataList;

    public AppAdapter() {
        this.applicationDataList = new ArrayList<>();
    }

    public void setApplicationDataList(ArrayList<ApplicationPOJO> applicationDataList){
        this.applicationDataList = applicationDataList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_card_item_view, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AppViewHolder appViewHolder = (AppViewHolder) holder;
        appViewHolder.bind(applicationDataList.get(position));
        Log.d(TAG, "onBindViewHolder: " + applicationDataList);
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + applicationDataList.size());
        return applicationDataList.size();
    }
}
