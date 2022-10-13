package com.proyecto.parcialtres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.proyecto.parcialtres.adapter.MovieAdapter;
import com.proyecto.parcialtres.presenter.IPresenterMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    IPresenterMovie presenter;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.recycler_view);
        this.adapter = new MovieAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }
}