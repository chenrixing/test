package com.pp.wms.storage.service.impl;

import com.pp.wms.storage.domain.entity.Book;
import com.pp.wms.storage.mapper.BookMapper;
import com.pp.wms.storage.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by Makkah at 2019/1/9 16:12
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public int selectCount() {
        return bookMapper.selectCount();
    }

    @Override
    public int selectCountLike(String ISBN, String title) {
        return bookMapper.selectCountLike(ISBN, title);
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Book selectOne(String ISBN) {
        return bookMapper.selectOne(ISBN);
    }

    @Override
    public List<Book> selectLike(String ISBN, String title) {
        return bookMapper.selectLike(ISBN, title);
    }

    @Override
    public int insertOne(Book book) throws SQLIntegrityConstraintViolationException {
        return bookMapper.insertOne(book);
    }

    @Override
    public int updateOne(Book book) {
        return bookMapper.updateOne(book);
    }

    @Override
    public int deleteOne(String ISBN) {
        return bookMapper.deleteOne(ISBN);
    }

    @Override
    public List<Book> select4Page(int page, int limit) {
        return bookMapper.select4Page(page, limit);
    }

    @Override
    public List<Book> select4PageLike(int page, int limit, String ISBN, String title) {
        return null;
    }

}
