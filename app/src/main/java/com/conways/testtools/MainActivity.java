package com.conways.testtools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.conways.testtools.toolsdata.entity.Tool;
import com.conways.testtools.toolsdata.ToolsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv=findViewById(R.id.recycle);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final ToolsAdapter adapter=new ToolsAdapter(ToolsManager.getInstance().getToolItems());
        adapter.setOnItemClickListener(new ToolsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Tool tool) {
                Toast.makeText(MainActivity.this,tool.getDes(),Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(adapter);


        findViewById(R.id.testButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEditing=adapter.isEditing();
                adapter.setEditing(!isEditing);
            }
        });
    }
}