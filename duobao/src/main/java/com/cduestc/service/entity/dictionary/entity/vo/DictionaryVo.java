package com.cduestc.service.entity.dictionary.entity.vo;

public class DictionaryVo {

    private String id;
    /**
     * 名称
     */
    private String title;
    /**
     * 父级KEY
     */
    private String pkey;
    /**
     * 标识
     */
    private String key;
    /**
     * 说明
     */
    private String note;

    /**
     * 创建时间
     */
    private Integer createtime;
    /**
     * 更新时间
     */
    private Integer updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
