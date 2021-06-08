package com.example.junaidkhancontactmenu.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.junaidkhancontactmenu.R;
import com.example.junaidkhancontactmenu.adapter.ListItemAdapter;
import com.example.junaidkhancontactmenu.pojo.ListItemPojo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListItemPojo> listOfItems;
    ListItemAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();

        initList();

    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.list_view);
        listOfItems = new ArrayList<>();
        customAdapter = new ListItemAdapter(this, listOfItems);
        listView.setAdapter(customAdapter);

    }

    private void initList() {
        add(listOfItems, R.drawable.image_1, "Steve Anderson", 216546421);
        add(listOfItems, R.drawable.image_2, "Jhony Khan", 56412354);
        add(listOfItems, R.drawable.image_3, "Ashfaq colleague", 234453254);
        add(listOfItems, R.drawable.image_4, "Taimoor", 123453254);
        add(listOfItems, R.drawable.image_5, "Fiance", 423423254);
        customAdapter.notifyDataSetChanged();
    }

    private void add(List<ListItemPojo> listItemsList, int image_1, String steve_anderson, int i) {
        listItemsList.add(new ListItemPojo(image_1, steve_anderson, i));
    }
}