package com.proyecto.parcialtres.model;

import com.proyecto.parcialtres.api.ApiClient;
import com.proyecto.parcialtres.api.BooksApi;
import com.proyecto.parcialtres.bean.Book;
import com.proyecto.parcialtres.presenter.IPresenterBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelBook implements IModelBook {

    private IPresenterBook presenter;
    private BooksApi api;

    public ModelBook(IPresenterBook presenter) {
        this.presenter = presenter;
        api = ApiClient.getInstance().create(BooksApi.class);
    }

    @Override
    public void getBooks() {
        Call<List<Book>> bookCall = api.getBooks();
        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                presenter.onBooksSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                presenter.onBooksError("Error el obtener los libros");
            }
        });
    }
}
