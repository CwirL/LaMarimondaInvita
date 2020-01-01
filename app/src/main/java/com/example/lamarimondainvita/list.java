package com.example.lamarimondainvita;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import android.app.ActionBar;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.SearchView;
import java.util.Collections;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class list extends AppCompatActivity {
    SearchView search;
    List<Event> lstEvent;
    List<Event> lstEventTemp;
    List<Integer> toRemove;
    List<Integer> toAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lstEvent = new ArrayList<>();
        lstEventTemp = new ArrayList<>();

        Resources res = getResources();
        TypedArray names = res.obtainTypedArray(R.array.names);
        TypedArray dates = res.obtainTypedArray(R.array.fecha);
        TypedArray locations = res.obtainTypedArray(R.array.lugar);
        TypedArray valores = res.obtainTypedArray(R.array.valor);
        TypedArray retos = res.obtainTypedArray(R.array.retos);
        for (int i = 0; i < names.length(); i++) {
            System.out.println(R.drawable.background);
            int id = getResources().getIdentifier("thumb" + Integer.toString(i+1), "drawable", getPackageName());
            lstEvent.add(new Event(names.getString(i), dates.getString(i),locations.getString(i), id, valores.getString(i), retos.getString((i)) ));
        }

        lstEventTemp.addAll(lstEvent);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycleView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstEventTemp);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setAdapter(myAdapter);

        search = (SearchView) findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.filter(newText);
                return true;
            }
        });
    }

    public void refreshRecycler(){
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycleView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstEvent);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setAdapter(myAdapter);
    }

}
