package com.cduestc.common.beans;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2017:51
 * 自定义错误类型
 */
public class MyException extends RuntimeException  {

    /**
     * 异常信息
     */
    private String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }
}
