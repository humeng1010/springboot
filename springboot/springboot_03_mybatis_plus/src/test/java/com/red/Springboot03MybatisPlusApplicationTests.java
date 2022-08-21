package com.red;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.red.mapper.BookMapper;
import com.red.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class Springboot03MybatisPlusApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById() {
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }

    @Test
    void testGetAll(){
        List<Book> books = bookMapper.selectList(null);
        System.out.println(books);
    }

}
