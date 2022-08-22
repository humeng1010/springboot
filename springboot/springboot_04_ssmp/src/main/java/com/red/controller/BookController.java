package com.red.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.red.controller.utils.R;
import com.red.pojo.Book;
import com.red.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        //模拟抛出异常
        if (Objects.equals(book.getName(),"123"))throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功(#^.^#)" : "添加失败o(╥﹏╥)o");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

//    @GetMapping("/pages")
//    public R getByPage(@RequestParam Integer currentPage,@RequestParam Integer pageSize){
//        Page<Book> bookPage = new Page<>(currentPage,pageSize);
//        bookService.page(bookPage);
//        return new R(true,bookPage);
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getByRestPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,
                           String type, String name, String description){
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(!"".equals(type)&&type!=null,Book::getType,type)
                          .like(!"".equals(name)&&name!=null,Book::getName,name)
                          .like(!"".equals(description)&&description!=null,Book::getDescription,description);
        Page<Book> bookPage = new Page<>(currentPage,pageSize);
        bookService.page(bookPage,lambdaQueryWrapper);
        return new R(true,bookPage);
    }

}
