package com.example.android.recyclerviewproject.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import com.example.android.recyclerviewproject.Adapter.ExampleAdapter;
import com.example.android.recyclerviewproject.Custom_Object.Category;
import com.example.android.recyclerviewproject.Custom_Object.ExampleItem;
import com.example.android.recyclerviewproject.Dialog.AddCategory;
import com.example.android.recyclerviewproject.Helper.RecyclerItemTouchHelper;
import com.example.android.recyclerviewproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private ArrayList<Category> myList, availableCat;
    private double totalHours;
    private ImageView addServBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //loadData();
        createAvailableCat();
        initAddButton();
    }

    private void createAvailableCat(){
        availableCat = new ArrayList<>();
        availableCat.add(new Category("School"));
        availableCat.add(new Category("Community"));
        availableCat.add(new Category("Custom"));
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED PREF", MODE_PRIVATE);
        Gson myGson = new Gson();
        String json = sharedPreferences.getString("service_list", null);
        Type myType = new TypeToken<ArrayList<ExampleItem>>() {
        }.getType();
        myList = myGson.fromJson(json, myType);
        if (myList == null) myList = new ArrayList<>();

        double temp = Double.longBitsToDouble(sharedPreferences.getLong("my_hours", Double.doubleToLongBits(0)));
        totalHours = temp;

    }

    private void initAddButton() {
        addServBtn = findViewById(R.id.addbtn);
        addServBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        AddCategory dialog = new AddCategory();
        dialog.setCategories(availableCat);
        dialog.setMyCont(CategoryActivity.this);
        dialog.show(getSupportFragmentManager(), "Add Category");
    }

}
