package com.pp.wms.storage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 货物，商品
 * Created by Makkah at 2019/1/8 11:16
 */
public abstract class Commodity implements Serializable {
    String id;              // 唯一识别,图书可设为ISBN码，其他商品可设为条码？还是应理解为在本仓库的关键索引？
    String name;            // 名字，具体子类可通过getBookName()之类来做区分
    String unit;            // 计价单位：
    BigDecimal price;       // 单价
    Integer amount;         // 量(数量或重量，以计价单位为参考)，可是有的以整数，有的可以是小数(如kg)，则可以设定一个计价单位unit为xxkg/包、箱、袋？
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;   // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp updateTime;   // 更新时间
    String comment;         // 备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
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
