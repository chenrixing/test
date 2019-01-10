package com.pp.wms.storage.service;

import com.pp.wms.storage.domain.entity.Book;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:11
 */
public interface BookService {
    List<Book> listAll();
}
