package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;

import java.util.List;

public interface IPresenterMovie {
    void getMovies();
    void onSucces(List<MovieIndividual> movies);
    void onError(String msg);


}
