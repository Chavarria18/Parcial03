package com.proyecto.parcialtres.view;

import com.proyecto.parcialtres.bean.Book;

import java.util.List;

public interface IViewBook {
    void onBookSuccess(List<Book> books);
    void onBookError(String msg);
}
