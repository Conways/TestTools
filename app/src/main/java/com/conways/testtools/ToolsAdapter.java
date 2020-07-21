package com.conways.testtools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.toolsdata.entity.Tool;
import com.conways.testtools.toolsdata.entity.ToolItem;
import com.conways.testtools.toolsdata.repository.ShortCutRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ToolsHolder> implements ToolsItemAdapter.OnEditClickListener, ToolsItemAdapter.OnItemClickListener {

    private boolean isEditing = false;

    private List<ToolItem> toolItems;

    public ToolsAdapter(List<ToolItem> toolItems) {
        this.toolItems = toolItems;
    }


    public boolean isEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
        this.notifyDataSetChanged();
    }


    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ToolsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToolsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tools, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToolsHolder holder, int position) {
        holder.tvTitle.setText(toolItems.get(position).getTitle());
        holder.tvSubTitle.setVisibility(View.GONE);
        holder.rvThumbs.setVisibility(View.GONE);
        ToolsItemAdapter adapter;
        if (!isEditing && toolItems.get(position).getId() == ToolsFactory.SHORTCUT) {
            adapter = new ToolsItemAdapter(new ArrayList<Tool>(), toolItems.get(position).getId());
            holder.tvSubTitle.setVisibility(View.VISIBLE);
            holder.rvThumbs.setVisibility(View.VISIBLE);
            ThumbAdapter thumbAdapter=new ThumbAdapter(toolItems.get(position).getTools());
            holder.rvThumbs.setAdapter(thumbAdapter);
        } else {
            adapter = new ToolsItemAdapter(toolItems.get(position).getTools(), toolItems.get(position).getId());
        }
        adapter.setEditing(isEditing);
        adapter.setEditClickListener(this);
        adapter.setOnItemClickListener(this);
        holder.rvTools.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return toolItems.size();
    }

    @Override
    public void onEditClick(boolean isShortCut, Tool tool) {
        if (isShortCut) {
            ShortCutRepository.getInstance().removeTool(tool);
            this.notifyDataSetChanged();
        } else {
            if (!ShortCutRepository.getInstance().isFull()) {
                ShortCutRepository.getInstance().addTool(tool);
                this.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(Tool tool) {

        if (isEditing) {
            return;
        }
        if (null == onItemClickListener) {
            return;
        }
        onItemClickListener.onItemClick(tool);
    }


    class ToolsHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        RecyclerView rvTools;
        TextView tvSubTitle;
        RecyclerView rvThumbs;

        public ToolsHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_tools_title);
            rvTools = itemView.findViewById(R.id.item_tools_tools);
            rvTools.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
            tvSubTitle=itemView.findViewById(R.id.item_tools_title_des);
            rvThumbs=itemView.findViewById(R.id.item_tools_title_thumbs);
            LinearLayoutManager layoutManager=new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rvThumbs.setLayoutManager(layoutManager);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Tool tool);
    }


}
