package com.mn.demo.bookstore.init;

import com.mn.demo.bookstore.Book;
import com.mn.demo.bookstore.db.BooksRepository;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class BookLoader implements ApplicationEventListener<ServerStartupEvent> {

    private final BooksRepository booksRepository;


    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        List<Book> allProducts = booksRepository.findAll().blockingGet();
        if (allProducts.stream().noneMatch(p -> p.getCategory().equals("fiction"))) {
            booksRepository.add(DemoBookFactory.fiction()).blockingGet();
        }

        if (allProducts.stream().noneMatch(p -> p.getCategory().equals("nonfiction"))) {
            booksRepository.add(DemoBookFactory.nonfiction()).blockingGet();
        }

        if (allProducts.stream().noneMatch(p -> p.getCategory().equals("spiritual"))) {
            booksRepository.add(DemoBookFactory.spiritual()).blockingGet();
        }

        if (allProducts.stream().noneMatch(p -> p.getCategory().equals("travel"))) {
            booksRepository.add(DemoBookFactory.travel()).blockingGet();
        }
    }


}
