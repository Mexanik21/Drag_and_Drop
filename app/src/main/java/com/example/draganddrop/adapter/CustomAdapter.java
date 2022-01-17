package com.example.draganddrop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.draganddrop.R;
import com.example.draganddrop.helper.ItemTouchHelperAdapter;
import com.example.draganddrop.madel.Member;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {
    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        TextView tv_first_name = ((CustomViewHolder) holder).tv_item;

        tv_first_name.setText(member.getFirstName());

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if(fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition; i++){
                Collections.swap(members,i,i+1);
            }
        }
        else {
            for (int i = fromPosition; i > toPosition; i--){
                Collections.swap(members,i,i-1);
            }

        }
        notifyItemMoved(fromPosition,toPosition);

    }

    @Override
    public void onItemDismiss(int position) {
        members.remove(position);
        notifyItemRemoved(position);
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView tv_item;
        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            tv_item = view.findViewById(R.id.tv_item);
        }
    }
}
