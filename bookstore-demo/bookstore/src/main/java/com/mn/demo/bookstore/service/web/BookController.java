package com.mn.demo.bookstore.service.web;

import com.mn.demo.bookstore.Book;
import com.mn.demo.bookstore.service.api.BookOperations;
import com.mn.demo.bookstore.service.domain.Books;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;

@Controller("/bookstore")
@RequiredArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
public class BookController implements BookOperations {
    private final Books books;


//    @Value("${discount.price}")
    private Object discount;
    @Override
    @ContinueSpan
    public Single<List<Book>> getAll() {
       return books.findAll();
    }

    @Override
    @ContinueSpan
    public Maybe<Book> get(@SpanTag("book.isbn") String isbn) {
//        System.out.println("-----discount is -----"+discount);
        return books.findOne(isbn);
    }
}
