package com.proyecto.parcialtres.api;

import com.proyecto.parcialtres.bean.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("/")
    Call<List<Movie>> getBooks();

}
