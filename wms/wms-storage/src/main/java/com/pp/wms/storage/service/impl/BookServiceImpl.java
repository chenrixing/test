package com.pp.wms.storage.service.impl;

import com.pp.wms.storage.domain.entity.Book;
import com.pp.wms.storage.mapper.BookMapper;
import com.pp.wms.storage.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Makkah at 2019/1/9 16:12
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> listAll() {
        return bookMapper.selectAll();
    }
}
