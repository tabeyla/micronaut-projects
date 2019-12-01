package com.mn.demo.bookstore.api.v1;

import com.mn.demo.bookstore.Book;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface BookOperations {

    @Get("/books")
    Single<List<Book>> getAll();

    @Get("/isbn/{isbn}")
    Maybe<Book> get(String isbn);
}
