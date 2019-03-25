package com.cduestc.service.entity.admin.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class AdminVo implements Serializable{


    /**
     * 修改时必填 ，否则为添加操作
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String password2;
    /**
     * 姓名
     */
    private String truename;
    /**
     *  非超级管理员必填
     */
    private String roleId;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 是否启用 1启用，0禁用
     */
    private String status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public AdminVo(String id, String username, String password, String password2, String truename, String roleId, String phone, String status, Integer createtime, Integer updatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.truename = truename;
        this.roleId = roleId;
        this.phone = phone;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public AdminVo(String username, String password, String password2, String truename, String roleId, String phone, String status) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.truename = truename;
        this.roleId = roleId;
        this.phone = phone;
        this.status = status;
    }

    public AdminVo() {
    }
}
