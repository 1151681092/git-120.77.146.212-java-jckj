package com.cduestc.service.entity.operate.entity.vo;

public class OperateVo {

    private String id;
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
