package com.cduestc.service.entity.operate.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
public class BaseOperate extends Model<BaseOperate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String title;
    /**
     * 模块标识
     */
    private String module;
    /**
     * 操作标识
     */
    private String operate;
    /**
     * 附加操作标识
     */
    private String plus;
    /**
     * 状态。1启用0停用
     */
    private Integer status;
    /**
     * 是否删除。1是0否
     */
    private Integer isdel;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BaseOperate{" +
        ", id=" + id +
        ", title=" + title +
        ", module=" + module +
        ", operate=" + operate +
        ", plus=" + plus +
        ", status=" + status +
        ", isdel=" + isdel +
        ", authorId=" + authorId +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
