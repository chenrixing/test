package com.pp.wms.storage.domain;

import com.pp.wms.storage.enums.UNIT;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 电脑设备实体类
 * Created by Makkah at 2019/1/7 16:15
 */
public class Computer extends Commodity {
    private String brand;   // 品牌
    private int ram;        // 运行内存
    private int rom;        // 硬盘容量


    public Computer() {
    }

    public Computer(long id, String brand, int ram, int rom) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.rom = rom;
    }

    public Computer(long id, String brand, int ram, int rom, long amount, Timestamp createTime, Timestamp updateTime, String comment, UNIT unit, double price) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.rom = rom;
        this.amount = amount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.comment = comment;
        this.unit = unit;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
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

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", brand:'" + brand + '\'' +
                ", ram:" + ram +
                ", rom:" + rom +
                ", amount:" + amount +
                ", createTime:" + createTime +
                ", updateTime:" + updateTime +
                ", comment:'" + comment + '\'' +
                '}';
    }
}
