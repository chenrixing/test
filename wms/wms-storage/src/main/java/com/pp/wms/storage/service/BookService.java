package com.pp.wms.storage.service;

import com.pp.wms.storage.domain.entity.Book;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:11
 */
public interface BookService {
    int selectCount();

    int selectCountLike(String ISBN, String title);

    List<Book> selectAll();

    Book selectOne(String ISBN);

    List<Book> selectLike(String ISBN, String title);

    int insertOne(Book book) throws SQLIntegrityConstraintViolationException;

    int updateOne(Book book);

    int deleteOne(String ISBN);

    List<Book> select4Page(int page, int limit);

    List<Book> select4PageLike(int page, int limit, String ISBN, String title);
}
