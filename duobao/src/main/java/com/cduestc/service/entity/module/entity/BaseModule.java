package com.cduestc.service.entity.module.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
@Getter
@Setter
public class BaseModule extends Model<BaseModule> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * 模块标识
     */
    private String module;
    /**
     * 外部模块的链接地址
     */
    private String link;
    /**
     * 类型。inner内部 out外部
     */
    private String type;
    /**
     * 节点左值
     */
    private Integer left;
    /**
     * 节点右值
     */
    private Integer right;
    /**
     * 节点父级id
     */
    private Integer pid;
    /**
     * 节点层级
     */
    private Integer deep;
    /**
     * 状态。1启用0停用
     */
    private Integer status;
    /**
     * 是否删除。1是0否
     */
    private Integer isdel;
    /**
     * 标记状态。用户更新节点数据
     */
    private Integer tmp;
    /**
     * 操作人员id
     */
    private Integer authorId;
    /**
     * 创建时间
     */
    private Integer createtime;
    /**
     * 更新时间
     */
    private Integer updatetime;


    @Override
    protected Serializable pkVal() {
        return null;
    }
}
