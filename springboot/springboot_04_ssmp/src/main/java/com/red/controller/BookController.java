package com.red.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.red.controller.utils.R;
import com.red.pojo.Book;
import com.red.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
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
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("/pages")
    public R getByPage(@RequestParam Integer currentPage,@RequestParam Integer pageSize){
        Page<Book> bookPage = new Page<>(currentPage,pageSize);
        bookService.page(bookPage);
        return new R(true,bookPage);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getByRestPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        Page<Book> bookPage = new Page<>(currentPage,pageSize);
        bookService.page(bookPage);
        return new R(true,bookPage);
    }
}
