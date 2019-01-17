package com.pp.wms.storage.mapper;

import com.pp.wms.storage.domain.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:02
 */
public interface BookMapper extends Mapper<Book, String> {
    List<Book> selectLike(@Param("ISBN") String ISBN,@Param("title") String title);
}
