package com.pp.wms.storage.mapper;

import com.pp.wms.storage.domain.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:02
 */
public interface BookMapper extends Mapper<Book, String> {
    List<Book> selectLike(@Param("ISBN") String ISBN, @Param("title") String title);

    @Override
    @Select("SELECT COUNT(*) FROM book")
    int selectCount();

    @Select("SELECT COUNT(*) FROM book WHERE ISBN LIKE \"%${ISBN}%\" AND title LIKE \"%${title}%\"")
    int selectCountLike(@Param("ISBN") String ISBN, @Param("title") String title);
}
