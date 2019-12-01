package com.mn.demo.bookstore.db;

import com.mn.demo.bookstore.Book;
import com.mn.demo.bookstore.service.domain.Books;
import com.mongodb.client.model.Filters;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class BooksRepository implements Books  {

    private final MongoClient mongoClient;

    @Override
    public Single<Book> add(Book book) {
        return Single.fromPublisher(getCollection().insertOne(book)).map(success -> book);
    }

    @Override
    public Single<List<Book>> findAll() {
        MongoCollection<Book> collection = getCollection();
        return Flowable.fromPublisher(collection.find()).toList();
    }

    @Override
    public Maybe<Book> findOne(String isbn) {
        return Flowable.fromPublisher(getCollection().find(Filters.eq("isbn", isbn)).limit(1)).firstElement();
    }

    private MongoCollection<Book> getCollection() {
        return mongoClient
                .getDatabase("bookstore")
                .getCollection("books", Book.class);
    }
}
