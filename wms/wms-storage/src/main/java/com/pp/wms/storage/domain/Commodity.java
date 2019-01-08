package com.pp.wms.storage.domain;

import com.pp.wms.storage.enums.UNIT;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 货物
 * Created by Makkah at 2019/1/8 11:16
 */
public abstract class Commodity implements Serializable {
    long id;
    UNIT unit;      // 计价单位：
    double price;   // 单价
    long amount;            // 量(数量或重量，以计价单位为参考)
    Timestamp createTime;   // 创建时间
    Timestamp updateTime;   // 更新时间
    String comment; // 备注

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UNIT getUnit() {
        return unit;
    }

    public void setUnit(UNIT unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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
}
