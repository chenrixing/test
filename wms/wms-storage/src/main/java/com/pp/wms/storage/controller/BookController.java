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
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*查*/

    // page和limit由layui table提交的分页参数名,page从1开始
    @GetMapping()
    RestModel<List<Book>> list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "ISBN", required = false) String ISBN, @RequestParam(value = "title", required = false) String title) {
        List<Book> books;
        int count;  // 数据总数
        if (!StringUtils.isBlank(ISBN) || !StringUtils.isBlank(title)) {  // 如果ISBN和title中有一个不为空    isEmpty只判断null和长度为0即空字符串，isBlank还会判断空格
            count = bookService.selectCountLike(ISBN, title);
            if (page != null && limit != null) {
                books = bookService.select4PageLike(page, limit, ISBN, title);
            } else {
                books = bookService.selectLike(ISBN, title);
            }
        } else {    // 如果无查询条件，则查询全部
            count = bookService.selectCount();
            if (page != null && limit != null) {
                books = bookService.select4Page(page, limit);
            } else {
                books = bookService.selectAll();
            }
        }
//        count = books.size();   // 数据总数，此数据必须经过一次无分页参数的查询来得到->那不是很浪费资源吗?->简化数据总数的查询，单独查一次select count(*)
//        if (page != null && limit != null) {
//            if (!StringUtils.isBlank(ISBN) || !StringUtils.isBlank(title)) {  //isEmpty只判断null和长度为0即空字符串，isBlank还会判断空格
//                books = bookService.select4PageLike(page, limit, ISBN, title);
//            } else {
//                books = bookService.select4Page(page, limit);
//            }
//        } else {
//
//        }
//        if (ISBN.length() > 0 || title.length() > 0) {->NullPointerException
        return new RestModel<>(Status.SUCCESS.getCode(), "请求成功", books, count);
    }

    @GetMapping("/{ISBN}")
    RestModel<Book> selectOne(@PathVariable("ISBN") String ISBN) {
        Book book = bookService.selectOne(ISBN);
        return book != null ? new RestModel<Book>(Status.SUCCESS.getCode(), "请求成功", book, 1) : new RestModel<Book>(Status.SUCCESS.getCode(), "无匹配的数据", null, 0);
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
