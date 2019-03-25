package com.cduestc.service.entity.ResquestDTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2111:17
 */
@Setter
@Getter
public class SortResquestDTO implements Serializable {

    private static final long serialVersionUID = -4737510365710281789L;

    //ID
    @NotBlank(message = "ID不能为空")
    private String id;

    //排序类型 （up 往上，down 往下）
    @NotBlank(message = "排序类型不能为空")
    private String  action;

}
