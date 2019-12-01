package com.mn.demo.bookstore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * Created by mandar on 11/23/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {


    private String name;
    private String author;
    private String isbn;
    private double price;
    private String category;






}
