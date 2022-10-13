package com.proyecto.parcialtres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.proyecto.parcialtres.adapter.MovieAdapter;
import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;
import com.proyecto.parcialtres.presenter.IPresenterMovie;
import com.proyecto.parcialtres.presenter.PresenterMovie;
import com.proyecto.parcialtres.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private IPresenterMovie presenter;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new PresenterMovie(this);
        this.presenter.getMovies();


        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.recycler_view);
        this.adapter = new MovieAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    public void onSucces(List<MovieIndividual> movies) {
        adapter.reloadData(movies);

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

    }
}

