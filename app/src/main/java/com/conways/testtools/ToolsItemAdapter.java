package com.conways.testtools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.conways.testtools.toolsdata.entity.Tool;
import com.conways.testtools.toolsdata.repository.ShortCutRepository;
import com.conways.testtools.toolsdata.ToolsFactory;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ToolsItemAdapter extends RecyclerView.Adapter<ToolsItemAdapter.ToolsItemHolder> {

    private List<Tool> tools;

    public int parentId;

    public ToolsItemAdapter(List<Tool> tools, int parentId) {
        this.tools = tools;
        this.parentId = parentId;
    }

    private boolean isEditing=false;


    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    private OnEditClickListener editClickListener;

    public void setEditClickListener(OnEditClickListener editClickListener) {
        this.editClickListener = editClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ToolsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToolsItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item_tools,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToolsItemHolder holder, int position) {
        final Tool tool=tools.get(position);
        holder.ivIcon.setImageResource(tool.getIcon());
        holder.tvDes.setText(tool.getDes());

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=editClickListener){
                    editClickListener.onEditClick(parentId== ToolsFactory.SHORTCUT,tool);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=onItemClickListener){
                    onItemClickListener.onItemClick(tool);
                }
            }
        });

        if (isEditing){
            if (parentId==ToolsFactory.SHORTCUT){
                holder.ivEdit.setVisibility(View.VISIBLE);
                holder.ivEdit.setBackgroundColor(0xffff0000);

            }else{
                if (ShortCutRepository.getInstance().inShortCut(tool)){
                    holder.ivEdit.setVisibility(View.GONE);
                }else{
                    holder.ivEdit.setVisibility(View.VISIBLE);
                    holder.ivEdit.setBackgroundColor(0xff0000ff);
                }
            }

        }else{
            holder.ivEdit.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return tools.size();
    }


    class ToolsItemHolder extends RecyclerView.ViewHolder {

        ImageView ivIcon;
        TextView tvDes;
        ImageView ivEdit;


        public ToolsItemHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon=itemView.findViewById(R.id.item_item_tools_icon);
            tvDes=itemView.findViewById(R.id.item_item_tools_des);
            ivEdit=itemView.findViewById(R.id.item_item_tools_edit);
        }
    }

    public interface OnEditClickListener {
        void onEditClick(boolean isShortCut,Tool tool);
    }

    public interface OnItemClickListener{
        void onItemClick(Tool tool);
    }

}
