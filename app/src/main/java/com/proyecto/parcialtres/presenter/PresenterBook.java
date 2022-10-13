package com.proyecto.parcialtres.presenter;

import com.proyecto.parcialtres.bean.Book;
import com.proyecto.parcialtres.model.ModelBook;
import com.proyecto.parcialtres.view.IViewBook;

import java.util.List;

public class PresenterBook implements IPresenterBook{

    private IViewBook view;
    private ModelBook model;

    public PresenterBook(IViewBook hola) {
        this.view = hola;
        this.model = new ModelBook(this);
    }

    @Override
    public void getBooks() {
        this.model.getBooks();
    }

    @Override
    public void onBooksSuccess(List<Book> books) {
        if (view == null)
            return;

        this.view.onBookSuccess(books);
    }

    @Override
    public void onBooksError(String msg) {
        if (view == null)
            return;

        this.view.onBookError(msg);
    }
}
