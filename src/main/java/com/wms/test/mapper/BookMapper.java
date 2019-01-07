package com.wms.test.mapper;



import com.wms.test.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    int insert(Book book);

    Book getByPrimaryKey(Long id);

    int updateByPrimaryKey(Book book);

    List<Book> selectAll();

    int delete(Long id);
}