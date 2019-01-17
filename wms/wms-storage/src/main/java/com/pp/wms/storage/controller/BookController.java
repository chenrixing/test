package com.pp.wms.storage.controller;

import com.pp.wms.storage.domain.entity.Book;
import com.pp.wms.storage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:11
 */
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/listAll", method = RequestMethod.GET)
    List<Book> listAll() {
        return bookService.listAll();
    }

}
