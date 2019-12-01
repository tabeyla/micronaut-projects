package com.mn.demo.bookstore.init;

import com.mn.demo.bookstore.Book;

import javax.inject.Singleton;
@Singleton
public class DemoBookFactory {

    //FICTION,NON_FICTION,SPIRITUAL,TRAVEL
    static Book fiction() {
        return new Book("A handmaid's taile","Margaret Atwood", "32456", 20.99, "fiction");
    }

    static Book nonfiction() {
        return new Book("Killers of the Flower Moon", "David Grann", "877544", 15.63, "nonfiction");
    }

    static Book spiritual() {
        return new Book("The Power of Now", "Eckhart Tolle", "6547238", 23.99, "spiritual");
    }

    static Book travel() {
        return new Book("On the road","Jack Kerouac", "32452", 35.10, "travel");
    }

}
