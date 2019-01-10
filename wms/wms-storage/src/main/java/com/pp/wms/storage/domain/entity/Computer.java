package com.pp.wms.storage.domain.entity;


/**
 * 电脑设备实体类
 * Created by Makkah at 2019/1/7 16:15
 */
public class Computer extends Commodity {
    private String barcode; // 条码,替代id
    private String brand;   // 品牌
    private String model;   // 型号
    private String ram;    // 运行内存
    private String rom;    // 硬盘容量

    public Computer() {
    }

    public Computer(String brand, String ram, String rom) {
        this.brand = brand;
        this.ram = ram;
        this.rom = rom;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"barcode\":\"")
                .append(barcode).append('\"');
        sb.append(",\"brand\":\"")
                .append(brand).append('\"');
        sb.append(",\"model\":\"")
                .append(model).append('\"');
        sb.append(",\"ram\":\"")
                .append(ram).append('\"');
        sb.append(",\"rom\":\"")
                .append(rom).append('\"');
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
