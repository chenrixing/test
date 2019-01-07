package com.wms.test.controller;

import com.wms.test.domain.Book;
import com.wms.test.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController
{

    @Autowired
    private BookServer bookServer;

    @RequestMapping("/getAll")
    public List<Book> selectAll(){
       return  this.bookServer.slectAll();
    }

    /*public String test(){

    }
*/

}
