package com.wms.test.service;

import com.wms.test.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface BookServer {


    void save(Book book);

    List<Book> slectAll();

}
