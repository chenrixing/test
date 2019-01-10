package com.pp.wms.storage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * PP
 * Created by Makkah at 2019/1/9 14:24
 */

public class Book extends Commodity {
    private String ISBN;            //图书版本号，相同图书每一个印刷版次具有相同的ISBN码
    private String title;           //书名，用父类的name替换即可
    private String author;          //作者
    private String press;           //出版社
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;   //出版日期，设置日期可用String，注入数据库时用sql的to_date()函数
    private Integer edition;        //版次

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"ISBN\":\"")
                .append(ISBN).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append(",\"press\":\"")
                .append(press).append('\"');
        sb.append(",\"publicationDate\":\"")
                .append(publicationDate).append('\"');
        sb.append(",\"edition\":")
                .append(edition);
        sb.append(",\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"unit\":\"")
                .append(unit).append('\"');
        sb.append(",\"price\":")
                .append(price);
        sb.append(",\"amount\":")
                .append(amount);
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"comment\":\"")
                .append(comment).append('\"');
        sb.append('}');
        return sb.toString();
    }
}

