package com.cduestc.common.beans;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2016:17
 */

public enum BeansEnum {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    DELETE_OK(10001,"DELETE_OK"),
    DELETE_NO(12001,"DELETE_NO")
    ;

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    BeansEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
