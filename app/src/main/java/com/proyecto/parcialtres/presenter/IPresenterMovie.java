package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Movie;

import java.util.List;

public interface IPresenterMovie {

    public List<Movie> onSucces(List<Movie>);
    public String onError(String);


}
