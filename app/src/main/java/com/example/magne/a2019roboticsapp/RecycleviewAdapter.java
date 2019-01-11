package com.example.magne.a2019roboticsapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHolder> {
    private static final String TAG = "com.example.magne.a2019roboticsapp.RecycleviewAdapter";

    private ArrayList<String> mTeamNames = new ArrayList<>();
    private Context mContext;

    public RecycleviewAdapter(ArrayList<String> item_name, Context context){
        mTeamNames = item_name;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.item_name.setText(mTeamNames.get(i));
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(this, TeamScoring.class);
                // startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTeamNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_name;
        RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
