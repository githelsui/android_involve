package com.example.android.recyclerviewproject.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.recyclerviewproject.Adapter.ExampleAdapter;
import com.example.android.recyclerviewproject.Adapter.MainCategoryAdapter;
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

//    Header
    private ArrayList<Category> myList, availableCat;
    private double totalHours;
    private TextView hoursHeader;
    private ImageView addServBtn;

//    RecyclerView
    private RecyclerView myRecycler;
    private MainCategoryAdapter myAdapter;
    private RecyclerView.LayoutManager myLayout;
    private CardView introMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //loadData();

        createAvailableCat();
        initRecyclerView();
        initAddButton();
    }

    private void createAvailableCat(){
        availableCat = new ArrayList<>();
        myList = new ArrayList<>();
        availableCat.add(new Category("School", 0));
        availableCat.add(new Category("Community", 1));
        availableCat.add(new Category("Custom", 2));
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

    private void initRecyclerView() {
        myRecycler = findViewById(R.id.recycler_view);
        introMsg = findViewById(R.id.introview);
        if (myList.size() == 0) {
            introMsg.setVisibility(View.VISIBLE);
            myRecycler.setVisibility(View.INVISIBLE);
        }
        hoursHeader = findViewById(R.id.numhrs_lbl);
        hoursHeader.setText(totalHours + " hours");
        myRecycler.setHasFixedSize(true);
        myLayout = new LinearLayoutManager(this);
        myAdapter = new MainCategoryAdapter(myList, this);
        myRecycler.setLayoutManager(myLayout);
        myRecycler.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int pos) {
//                openProgActivity(pos);
//            }
//        });
//        ItemTouchHelper.SimpleCallback itemTouchHelperCallback =
//                new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, new RecyclerItemTouchHelper.RecyclerItemTouchHelperListener() {
//                    @Override
//                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
//                        openDeleteDialog(viewHolder);
//                    }
//                });
//        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(myRecycler);

    }

}
