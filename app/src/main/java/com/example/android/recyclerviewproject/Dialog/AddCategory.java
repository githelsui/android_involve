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
import android.widget.Toast;

import com.example.android.recyclerviewproject.Activity.MainActivity;
import com.example.android.recyclerviewproject.Adapter.CategoryCircleAdapter;
import com.example.android.recyclerviewproject.Custom_Object.Category;
import com.example.android.recyclerviewproject.Custom_Object.RandomColor;
import com.example.android.recyclerviewproject.R;

import java.util.ArrayList;

public class AddCategory extends AppCompatDialogFragment {

    private ArrayList<Category> categories;
    private Context myCont;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.BottomSheetDialog);

        BottomSheetDialog bottom = new BottomSheetDialog((getActivity()));
        View sheetView = (getActivity()).getLayoutInflater().inflate(R.layout.add_category, null);
        bottom.setContentView(sheetView);
        System.out.println("help");
        initRecycler(sheetView);
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        final View myView = inflater.inflate(R.layout.layout_dialog, null);
//        builder.setView(myView);

//        final Dialog myDialog = builder.create();
        Window myWindow = bottom.getWindow();
        myWindow.getAttributes().windowAnimations = R.style.DialogSlide;
        View v = myWindow.getDecorView();
       // myWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottom.setCanceledOnTouchOutside(false);
        myWindow.setLayout(100 /*our width*/, ViewGroup.LayoutParams.MATCH_PARENT);
        bottom.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
//                Button saveBtn = ((AlertDialog) myDialog).getButton(AlertDialog.BUTTON_POSITIVE);
//                saveBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
            }

        });
        return bottom;
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
        RecyclerView recycler = myView.findViewById(R.id.categoryrecycler);
        recycler.setLayoutManager(lin);
        CategoryCircleAdapter adapter = new CategoryCircleAdapter(categories, myCont);
        recycler.setAdapter(adapter);
        System.out.println("fuck this");
    }

}
