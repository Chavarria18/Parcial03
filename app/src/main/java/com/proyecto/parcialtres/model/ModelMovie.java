package com.proyecto.parcialtres.model;

import com.proyecto.parcialtres.api.MovieApi;
import com.proyecto.parcialtres.api.RetrofitClient;
import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.presenter.IPresenterMovie;
import com.proyecto.parcialtres.presenter.PresenterMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMovie implements IModelMovie{
    MovieApi api;
    IPresenterMovie presenter;

    public ModelMovie(MovieApi api) {
        this.api = RetrofitClient.getInstance().create(MovieApi.class);
        this.presenter = PresenterMovie(this);
    }

    @Override
    public void getMovies() {

        Call<List<Movie>> movieCall = api.getBooks();


        movieCall.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                presenter.onSucces(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                presenter.onError("Error el obtener los libros");
            }
        });


    }
}
