package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Movie;
import com.proyecto.parcialtres.view.IView;

import java.util.List;

public class PresenterMovie implements IView {
    @Override
    public void getMovies() {

    }

    @Override
    public List<Movie> OnSuccesMovies() {
        return null;
    }

    @Override
    public String OnErrorMovie() {
        return null;
    }
}
