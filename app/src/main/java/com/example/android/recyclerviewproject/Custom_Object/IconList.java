package com.example.android.recyclerviewproject.Custom_Object;

import com.example.android.recyclerviewproject.R;

public class IconList {

    private int[] icnList;

    public IconList(){
        makeList();
    }

    private void makeList(){
        int[] arr = { R.drawable.ic_school_black_24dp, R.drawable.ic_nonschool, R.drawable.add_48};
        icnList = arr;
    }

    public int[] getIcnList() {
        return icnList;
    }
}
