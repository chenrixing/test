package com.pp.wms.storage.mapper;

import com.pp.wms.storage.domain.entity.Book;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:02
 */
public interface BookMapper {
    List<Book> selectAll();

//    @Insert("INSERT INTO book (publication_date) VALUES(to_date(#{}))")
//    void addBook(Book book);
}
