package com.cduestc.service.entity.module.entity.param;

import com.cduestc.service.entity.module.entity.BaseModule;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2114:48
 * 删除模块
 */
@Setter
@Getter
public class ModuleParam  extends BaseModule implements Serializable {

    private static final long serialVersionUID = 7742122668568580735L;

    /**
     * id
     */
    private String id;
    /**
     * 类型，inner 内部,out外部。添加、修改时必填
     */
    private String type;
    /**
     * 父级ID，添加、修改时必填
     */
    private Integer pid;
    /**
     * 标题，添加、修改时必填
     */
    private String title;

    /**
     * 模块标识,添加、修改时必填
     */
    private String module;

}
