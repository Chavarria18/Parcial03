package com.proyecto.parcialtres.model;

import com.proyecto.parcialtres.api.MovieApi;
import com.proyecto.parcialtres.api.RetrofitClient;
import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;
import com.proyecto.parcialtres.presenter.IPresenterMovie;
import com.proyecto.parcialtres.presenter.PresenterMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMovie implements IModelMovie{
    MovieApi api;
    IPresenterMovie presenter;

    public ModelMovie(IPresenterMovie presenter) {
        this.api = RetrofitClient.getInstance().create(MovieApi.class);
        this.presenter =  presenter;
    }

    @Override
    public void getMovies() {

        Call<Movie> movieCall = api.getBooks();
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                System.out.println(response.body());
                Movie peliculas = response.body() ;
                System.out.println(peliculas.mMovies);
                presenter.onSucces(response.body().mMovies);
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                presenter.onError("Error el obtener los libros");
            }
        });


    }
}
