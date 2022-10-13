package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Book;

import java.util.List;

public interface IPresenterBook {
    void getBooks();
    void onBooksSuccess(List<Book> books);
    void onBooksError(String msg);
}
