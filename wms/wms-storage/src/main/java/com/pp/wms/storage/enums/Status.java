package com.pp.wms.storage.enums;

/**
 * Created by Makkah at 2019/1/16 14:49
 */
public enum Status {
    SUCCESS("SUCCESS", 200), FAILURE("FAILURE", 401);
    private String descritpion;
    private int code;

    public String getDescritpion() {
        return descritpion;
    }

    public int getCode() {
        return code;
    }

    Status(String descritpion, int code) {
        this.descritpion = descritpion;
        this.code = code;
    }
}
