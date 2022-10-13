package com.proyecto.parcialtres.view;

import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;

import java.util.List;

public interface IView {


    void onSucces(List<MovieIndividual> movies);
    void onError(String msg);

}
