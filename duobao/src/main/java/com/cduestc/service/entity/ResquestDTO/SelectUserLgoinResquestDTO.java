package com.cduestc.service.entity.ResquestDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2017:18
 * 用户登录传的参数
 */
@Getter
@Setter
@ToString
public class SelectUserLgoinResquestDTO implements Serializable {

    private static final long serialVersionUID = -8477875141648298289L;

    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;
}
