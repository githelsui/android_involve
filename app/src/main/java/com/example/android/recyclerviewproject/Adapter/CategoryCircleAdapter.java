package com.example.android.recyclerviewproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.recyclerviewproject.Custom_Object.Category;
import com.example.android.recyclerviewproject.Custom_Object.ExampleItem;
import com.example.android.recyclerviewproject.R;

import java.util.ArrayList;

public class CategoryCircleAdapter  extends RecyclerView.Adapter<CategoryCircleAdapter.ViewHolder>{

    private ArrayList<Category> myCategories;
    private Context myContext;


    public CategoryCircleAdapter(ArrayList<Category> list, Context cont){
        myCategories = list;
        myContext = cont;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.circle_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.type.setText(myCategories.get(i).getMyName());
        System.out.println("this runs");
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, myCategories.get(i).getMyName() + " Category Selected", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return myCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        FloatingActionButton button;
        TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            button = itemView.findViewById(R.id.imagebtn);

        }
    }
}
