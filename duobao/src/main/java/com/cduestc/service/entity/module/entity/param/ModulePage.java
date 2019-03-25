package com.cduestc.service.entity.module.entity.param;


import java.io.Serializable;

public class ModulePage implements Serializable {


    private static final long serialVersionUID = 6017579072441982950L;


    /**
     * 父级ID
     */
    private Integer pid;

    /**
     *
     * 模块标识
     */
    private String module;

    /**
     * 页码
     */
    private String page;

    /**
     * 一页显示条数
     */
    private String limit;
}
