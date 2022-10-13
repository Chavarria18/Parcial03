package com.proyecto.parcialtres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.proyecto.parcialtres.adapter.BookAdapter;
import com.proyecto.parcialtres.adapter.MovieAdapter;
import com.proyecto.parcialtres.bean.Book;
import com.proyecto.parcialtres.bean.MovieIndividual;
import com.proyecto.parcialtres.presenter.IPresenterBook;
import com.proyecto.parcialtres.presenter.IPresenterMovie;
import com.proyecto.parcialtres.presenter.PresenterBook;
import com.proyecto.parcialtres.presenter.PresenterMovie;
import com.proyecto.parcialtres.view.IView;
import com.proyecto.parcialtres.view.IViewBook;
import com.proyecto.parcialtres.view.IViewBookMovie;

import java.util.ArrayList;
import java.util.List;

public class BooksAndMovie extends AppCompatActivity implements  IView, IViewBook {
    private IPresenterMovie presentermovie;
    private IPresenterBook presenterbook;
    private MovieAdapter adapter;
    private BookAdapter adapterb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_and_movie);
        this.presentermovie = new PresenterMovie(this);
        this.presentermovie.getMovies();
        this.presenterbook = new PresenterBook(this);
        this.presenterbook.getBooks();


        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.movies_list);
        this.adapter = new MovieAdapter(new ArrayList<>());
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        this.adapterb = new BookAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapterb);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onSucces(List<MovieIndividual> movies) {
        adapter.reloadData(movies);

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onBookSuccess(List<Book> books) {
        adapterb.reloadData(books);

    }

    @Override
    public void onBookError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();


    }
}