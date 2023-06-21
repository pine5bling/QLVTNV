package com.example.qlvtnv.activity;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VTNVAdapter extends RecyclerView.Adapter<VTNVAdapter.VTNVVH> {

    @NonNull
    @Override
    public VTNVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VTNVVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class VTNVVH extends RecyclerView.ViewHolder {
        public VTNVVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
