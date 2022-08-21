package com.red.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.red.mapper.BookMapper;
import com.red.pojo.Book;
import com.red.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;


}
