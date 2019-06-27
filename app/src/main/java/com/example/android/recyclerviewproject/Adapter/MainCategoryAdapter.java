package com.example.android.recyclerviewproject.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recyclerviewproject.Custom_Object.Category;
import com.example.android.recyclerviewproject.R;

import java.util.ArrayList;
public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> myList;
    private Context myContext;

    public MainCategoryAdapter(ArrayList<Category> list, Context cont){
        myContext = cont;
        myList = list;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater obj = LayoutInflater.from(viewGroup.getContext());
        View newView = obj.inflate(R.layout.category_item, viewGroup, false);
        CategoryViewHolder mySelf = new CategoryViewHolder(newView);
        return mySelf;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        Category obj = myList.get(i);
        (categoryViewHolder.mName).setText("Community");
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView mName;
        public TextView mHrs;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.category_icn);
            mName = itemView.findViewById(R.id.text_view1);
            mHrs = itemView.findViewById(R.id.text_view2);
        }
    }
}
