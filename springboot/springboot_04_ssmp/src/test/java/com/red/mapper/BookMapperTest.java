package com.red.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.red.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById(){
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }

    @Test
    void testInsert(){
        Book book = new Book();
        book.setType("计算机");
        book.setName("Mysql");
        book.setDescription("Mysql入门到精通");
        bookMapper.insert(book);
    }
    @Test
    void testUpdateById(){
        Book book = new Book();
        book.setId(1);
        book.setType("计算机");
        book.setName("Spring");
        book.setDescription("Spring入门到精通");
        bookMapper.updateById(book);
    }

    @Test
    void testGetAll(){
        bookMapper.selectList(null);
    }

    @Test
    void testGetByPage(){
        Page<Book> bookPage = new Page<>(1, 5);
        bookMapper.selectPage(bookPage,null);
        List<Book> books = bookPage.getRecords();
        System.out.println(books);

    }

    @Test
    void testGetByCondition(){
        String name = "t";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(!Objects.isNull(name),Book::getType,name);
        List<Book> books = bookMapper.selectList(lambdaQueryWrapper);
        System.out.println(books);
    }

}
