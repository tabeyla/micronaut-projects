package com.mn.demo.bookstore.gateway;


import com.mn.demo.bookstore.Book;
import com.mn.demo.bookstore.gateway.client.v1.BookStoreGatewayClient;
import com.mn.demo.bookstore.service.api.BookOperations;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.micronaut.views.View;
import io.reactivex.Maybe;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/bookstore")
public class BookStoreGatewayController implements BookOperations  {

    @Inject
    private  BookStoreGatewayClient client;

    @Get
//    @View("home")
    @ContinueSpan
    @Override
    public Single<List<Book>> getAll() {
        return client.getAll();
    }

//    @Get("/{isbn}")
    @ContinueSpan
    @Override
    public Maybe<Book> get(@SpanTag("book.isbn") String isbn) {
        return client.get(isbn);
    }
}
