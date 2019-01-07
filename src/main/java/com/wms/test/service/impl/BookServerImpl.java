package com.wms.test.service.impl;

import com.wms.test.domain.Book;
import com.wms.test.mapper.BookMapper;
import com.wms.test.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServerImpl implements BookServer {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void save(Book book) {
        this.bookMapper.insert(book);
    }

    @Override
    public List<Book> slectAll() {
        System.err.print("test");
        return this.bookMapper.selectAll();
    }

}
