package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.bean.MovieIndividual;
import com.proyecto.parcialtres.model.IModelMovie;
import com.proyecto.parcialtres.model.ModelMovie;
import com.proyecto.parcialtres.view.IView;

import java.util.List;

public class PresenterMovie implements IPresenterMovie {

    private IView view;
    private IModelMovie model;

    public PresenterMovie(IView view) {
        this.view = view;
        this.model = new ModelMovie(this);
    }

    @Override
    public void getMovies() {
        this.model.getMovies();

    }

    @Override
    public void onSucces(List<MovieIndividual> movies) {
        if(view == null)
            return;
        this.view.onSucces(movies);
    }

    @Override
    public void  onError(String msg) {
        if(view == null)
            return;
        this.view.onError(msg);
    }
}
