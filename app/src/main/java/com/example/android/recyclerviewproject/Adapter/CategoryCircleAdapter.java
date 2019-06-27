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
import com.example.android.recyclerviewproject.Custom_Object.IconList;
import com.example.android.recyclerviewproject.R;

import java.util.ArrayList;

public class CategoryCircleAdapter  extends RecyclerView.Adapter<CategoryCircleAdapter.ViewHolder>{

    private ArrayList<Category> myCategories;
    private OnItemClickListener mListener;
    private Context myContext;
    private int[] icons;


    public CategoryCircleAdapter(ArrayList<Category> list, Context cont){
        myCategories = list;
        myContext = cont;
        icons = (new IconList()).getIcnList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.circle_item, viewGroup, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.type.setText(myCategories.get(i).getMyName());
        viewHolder.button.setImageResource(icons[myCategories.get(i).getImageIndex()]);

    }

    @Override
    public int getItemCount() {
        return myCategories.size();
    }

    public interface OnItemClickListener{
        void passNewCategory(Category temp);
        void openCustom();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        FloatingActionButton button;
        TextView type;
        private OnItemClickListener mListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            mListener = listener;
            button = itemView.findViewById(R.id.imagebtn);
            btnClicked();

        }

        private void btnClicked(){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                           if(type.getText().toString().equals("School")){
                               mListener.passNewCategory(new Category("School", 0));
                           }
                           else if(type.getText().toString().equals("Community")) {
                               mListener.passNewCategory(new Category("Community", 1));
                           }
                           else{
                              //set recycler view invisible and edittext to visible
                               mListener.openCustom();
                           }
                        }
                    }
                }
            });
        }
    }
}
