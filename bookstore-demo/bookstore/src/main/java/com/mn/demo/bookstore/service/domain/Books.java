package com.mn.demo.bookstore.service.domain;

import com.mn.demo.bookstore.Book;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface Books {

    Single<Book> add(Book book);

    Single<List<Book>> findAll();

    Maybe<Book> findOne(String isbn);
}
