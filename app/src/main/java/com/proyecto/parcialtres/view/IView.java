package com.proyecto.parcialtres.view;

import com.proyecto.parcialtres.bean.Movie;

import java.util.List;

public interface IView {

    public void getMovies();
    public List<Movie> OnSuccesMovies();
    public String OnErrorMovie();

}
