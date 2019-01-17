package com.pp.wms.storage.controller;

import com.pp.wms.storage.domain.entity.Book;
import com.pp.wms.storage.domain.model.RestModel;
import com.pp.wms.storage.enums.Status;
import com.pp.wms.storage.service.BookService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * PP
 * Created by Makkah at 2019/1/9 16:11
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    /*查*/
    @GetMapping()
    RestModel<List<Book>> list(@RequestParam(value = "ISBN", required = false) String ISBN, @RequestParam(value = "title", required = false) String title) {
        List<Book> books;
//        if (ISBN.length() > 0 || title.length() > 0) {->NullPointerException
        if (!StringUtils.isBlank(ISBN) || !StringUtils.isBlank(title)) {  //isEmpty只判断null和长度为0即空字符串，isBlank还会判断空格
            books = bookService.selectLike(ISBN, title);
        } else {
            books = bookService.selectAll();
        }
        return new RestModel<>(Status.SUCCESS.getCode(), "请求成功", books);
    }

    @GetMapping("/{ISBN}")
    RestModel<Book> selectOne(@PathVariable("ISBN") String ISBN) {
        Book book = bookService.selectOne(ISBN);
        return new RestModel<Book>(Status.SUCCESS.getCode(), "请求成功", book);
    }

    /*增*/
    @PostMapping()
    RestModel addBook(Book book) {
        int addResult;
        try {
            addResult = bookService.insertOne(book);
        } catch (SQLIntegrityConstraintViolationException e) {   // 主键字段(ISBN)重复或者not null的字段值为null
            e.printStackTrace();
            return new RestModel<>(Status.FAILURE.getCode(), "数据添加失败，可能是主键字段(ISBN)重复或某些字段不能为空", null);
        }
        if (addResult == 1) {
            return new RestModel<>(Status.SUCCESS.getCode(), "数据添加成功", null);
        } else {
            return new RestModel<>(Status.FAILURE.getCode(), "出现未知异常", null);
        }
    }

    /*改*/
//    @PutMapping()
//    RestModel updateBook(Book book) {
//    }8：00bxj 9：00xp 10：00 hm 10：04 10：19
//
    /*删*/
    @DeleteMapping("/{ISBN}")
    RestModel deleteBook(@PathVariable("ISBN") String ISBN) {
        int deleteResult = bookService.deleteOne(ISBN);
        if (deleteResult == 1) {
            return new RestModel<>(Status.SUCCESS.getCode(), "数据删除成功", null);
        } else if (deleteResult == 0) {
            return new RestModel<>(Status.FAILURE.getCode(), "数据删除失败，可能是不存在该ISBN", null);
        } else {
            return new RestModel<>(Status.FAILURE.getCode(), "出现未知异常", null);
        }
    }

//    /**
//     * 更新某本书的部分字段，有点多余？
//     *
//     * @param id
//     * @param book
//     */
//    @PatchMapping("/{id}")
//    RestModel updateBook(@RequestParam(value = "id", required = true) String id, Book book) {
//    }

}
