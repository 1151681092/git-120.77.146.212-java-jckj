package com.cduestc.service.entity.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-20
 */
@NoArgsConstructor
@AllArgsConstructor
public class BaseAdmin extends Model<BaseAdmin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登陆账号
     */
    private String username;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String truename;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 状态。1启用0停用
     */
    private Integer status;
    /**
     * 是否删除。1是0否
     */
    private Integer isdel;
    /**
     * 登陆时间
     */
    private Integer logintime;
    /**
     * 登陆标识
     */
    private String token;
    /**
     * 操作人员id
     */
    private Integer authorId;
    /**
     * 身份证号码
     */
    private String cardNumber;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 性别  1男0女
     */
    private Integer sex;
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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
        return "BaseAdmin{" +
        ", id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", truename=" + truename +
        ", roleId=" + roleId +
        ", status=" + status +
        ", isdel=" + isdel +
        ", logintime=" + logintime +
        ", token=" + token +
        ", authorId=" + authorId +
        ", cardNumber=" + cardNumber +
        ", phone=" + phone +
        ", sex=" + sex +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
    public BaseAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
