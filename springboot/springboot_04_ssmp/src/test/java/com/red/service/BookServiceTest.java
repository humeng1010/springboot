package com.red.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.red.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        Book book = bookService.getById(1);
        System.out.println(book);
    }

    @Test
    void testPage(){
        Page<Book> bookPage = new Page<>(2,5);
        bookService.page(bookPage);
        List<Book> books = bookPage.getRecords();
        System.out.println(books);
    }
}
