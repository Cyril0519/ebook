package com.wxy.book.controller;


import com.wxy.book.domain.Book;
import com.wxy.book.service.BookService;
import com.wxy.common.group.Delete;
import com.wxy.common.group.Insert;
import com.wxy.common.group.Update;
import com.wxy.common.pojo.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 查询书籍
    @GetMapping("/list")
    public Resp list() {
        List<Book> list = bookService.list();
        return Resp.success(list);
    }

    // 添加书籍
    @PostMapping("/add")
    public Resp add(@Validated({Insert.class}) @RequestBody Book book) {
        bookService.save(book);
        return Resp.success("添加成功");
    }

    // 修改书籍
    @PutMapping("/update")
    public Resp update(@Validated(Update.class) @RequestBody Book book) {
        bookService.updateById(book);
        return Resp.success("修改成功");
    }

    // 删除书籍
    @DeleteMapping("/delete")
    public Resp delete(@Validated(Delete.class)@RequestParam Long id) {
        bookService.removeById(id);
        return Resp.success("删除成功");
    }

    // 查询书籍详情
    @GetMapping("/detail")
    public Resp detail(@RequestParam Long id) {
        Book book = bookService.getById(id);
        return Resp.success(book);
    }
}
