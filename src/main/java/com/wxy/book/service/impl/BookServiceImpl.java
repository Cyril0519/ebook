package com.wxy.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.book.domain.Book;
import com.wxy.book.service.BookService;
import com.wxy.book.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author wuxingyu
* @description 针对表【t_book】的数据库操作Service实现
* @createDate 2024-07-10 09:28:17
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




