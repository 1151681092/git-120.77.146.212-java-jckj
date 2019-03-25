package com.cduestc.common.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2015:56
 * 把返回数据封装威一个JSON数据
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class HyResult<T> {

    //描述信息
    private String message = "";

    //状态码
    private int code;

    //数据
    private T data ;

    //返回信息  默认是1
    private int result = 1;

    public HyResult(String message) {
        this.message = message;
    }

    public HyResult(String message, int code, T data, int result) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.result = result;
    }

    public static <T>HyResult<T> SUCCESS(String msg, int code,T  data, int result) {
        return new HyResult<T>(msg, code,data,result);
    }

    public static <T>HyResult<T> FAIL(String msg, int code,T  data, int result) {
        return new HyResult<T>(msg, BeansEnum.ERROR.getCode(),data,result);
    }

}
