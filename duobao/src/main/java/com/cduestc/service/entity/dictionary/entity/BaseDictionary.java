package com.cduestc.service.entity.dictionary.entity;

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
public class BaseDictionary extends Model<BaseDictionary> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String title;
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
     * 父级KEY
     */
    private String pkey;
    /**
     * KEY
     */
    private String key;
    /**
     * 值
     */
    private String value;
    /**
     * 说明
     */
    private String note;
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

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
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

    public Integer getTmp() {
        return tmp;
    }

    public void setTmp(Integer tmp) {
        this.tmp = tmp;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        return "BaseDictionary{" +
        ", id=" + id +
        ", title=" + title +
        ", left=" + left +
        ", right=" + right +
        ", pid=" + pid +
        ", deep=" + deep +
        ", status=" + status +
        ", isdel=" + isdel +
        ", tmp=" + tmp +
        ", pkey=" + pkey +
        ", key=" + key +
        ", value=" + value +
        ", note=" + note +
        ", authorId=" + authorId +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
