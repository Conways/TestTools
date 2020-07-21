package com.conways.testtools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.conways.testtools.toolsdata.entity.Tool;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/30
 * Describe:
 */
public class ThumbAdapter extends RecyclerView.Adapter<ThumbAdapter.ThumbHolder> {

    private List<Tool> tools;


    public ThumbAdapter(List<Tool> tools) {
        this.tools = tools;
    }

    @NonNull
    @Override
    public ThumbHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThumbHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thumb, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ThumbHolder holder, int position) {
        holder.ivThumb.setImageResource(tools.get(position).getIconThumb());
    }

    @Override
    public int getItemCount() {
        return tools.size();
    }

    class ThumbHolder extends RecyclerView.ViewHolder {

        ImageView ivThumb;

        public ThumbHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.item_thumb_icon);
        }
    }
}
