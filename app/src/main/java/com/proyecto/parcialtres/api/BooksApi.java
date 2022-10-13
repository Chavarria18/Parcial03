package com.proyecto.parcialtres.api;

import com.proyecto.parcialtres.bean.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BooksApi {

    @GET("/books.json")
    Call<List<Book>> getBooks();
}
