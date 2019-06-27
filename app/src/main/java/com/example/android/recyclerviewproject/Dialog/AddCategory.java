package com.example.android.recyclerviewproject.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.recyclerviewproject.Activity.MainActivity;
import com.example.android.recyclerviewproject.Adapter.CategoryCircleAdapter;
import com.example.android.recyclerviewproject.Adapter.ExampleAdapter;
import com.example.android.recyclerviewproject.Custom_Object.Category;
import com.example.android.recyclerviewproject.Custom_Object.RandomColor;
import com.example.android.recyclerviewproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddCategory extends AppCompatDialogFragment {

    private ArrayList<Category> categories;
    private Context myCont;
    private RecyclerView recycler;
    private RelativeLayout customView;
    private TextView title;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.BottomSheetDialog);
        BottomSheetDialog bottom = new BottomSheetDialog((getActivity()));
        View sheetView = (getActivity()).getLayoutInflater().inflate(R.layout.add_category, null);
        bottom.setContentView(sheetView);
        initViews(sheetView);
        initRecycler(sheetView);
        Window myWindow = bottom.getWindow();
        myWindow.getAttributes().windowAnimations = R.style.DialogSlide;
        bottom.setCanceledOnTouchOutside(true);
        myWindow.setLayout(100 /*our width*/, ViewGroup.LayoutParams.MATCH_PARENT);
        return bottom;
    }

    private void initViews(View myView){
        customView = myView.findViewById(R.id.custom_view);
        title = myView.findViewById(R.id.title);
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setMyCont(Context myCont) {
        this.myCont = myCont;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Context getMyCont() {
        return myCont;
    }

    private void initRecycler(View myView){
        LinearLayoutManager lin = new LinearLayoutManager(myCont, LinearLayoutManager.HORIZONTAL, false);
        recycler = myView.findViewById(R.id.categoryrecycler);
        recycler.setLayoutManager(lin);
        CategoryCircleAdapter adapter = new CategoryCircleAdapter(categories, myCont);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new CategoryCircleAdapter.OnItemClickListener() {
            @Override
            public void passNewCategory(Category temp) {
                Toast.makeText(myCont, temp.getMyName() + "  Category Added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void openCustom() {
                customView();
            }
        });
    }

    private void customView(){
        customView.setVisibility(View.VISIBLE);
        title.setText("Custom Category");
        recycler.setVisibility(View.INVISIBLE);
    }

}
