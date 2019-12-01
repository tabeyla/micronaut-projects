package com.mn.demo.bookstore.gateway.client.v1.fallback;

import com.mn.demo.bookstore.Book;
import com.mn.demo.bookstore.gateway.client.v1.BookStoreGatewayClient;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Maybe;
import io.reactivex.Single;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Singleton
@Fallback
public class BookStoreGatewayClientFallback implements BookStoreGatewayClient {
    @Override
    public Single<List<Book>> getAll() {
        Book book = new Book("foo","bar","12345",4.5,"foo");

        return Single.just(Arrays.asList(book));
    }

    @Override
    public Maybe<Book> get(String isbn) {
        return Maybe.empty();
    }
}
