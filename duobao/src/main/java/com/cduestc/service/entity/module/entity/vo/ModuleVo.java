package com.cduestc.service.entity.module.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ModuleVo implements Serializable {
    private static final long serialVersionUID=3468268418880982244L;

          /*  "id": "2",
            "title": "系统管理",
            "icon": "glyphicon glyphicon-cog",
            "module": "top_system",
            "link": "",
            "type": "inner",
            "left": "2",
            "right": "17",
            "pid": "1",
            "deep": "1",
            "status": "1",
            "author_id": "1",
            "createtime": "1531115057",
            "updatetime": "1531115057"*/

    @NotBlank(message = "ID不能为空")
    private Integer id;
    @NotBlank(message = "名称不能为空")
    private String title;
    @NotBlank(message = "图标不能为空")
    private String icon;
    @NotBlank(message = "模块标识不能为空")
    private String module;
    @NotBlank(message = "外部模块的链接地址不能为空")
    private String link;
    @NotBlank(message = "类型。inner内部 out外部不能为空")
    private String type;
    @NotBlank(message = "节点左值不能为空")
    private Integer left;
    @NotBlank(message = "节点右值不能为空")
    private Integer right;
    @NotBlank(message = "节点父级id不能为空")
    private Integer pid;
    @NotBlank(message = "节点层级不能为空")
    private Integer deep;
    @NotBlank(message = "状态。1启用0停用不能为空")
    private Integer status;
    @NotBlank(message = "是否删除。1是0否不能为空")
    private Integer isdel;
     @NotBlank(message = "标记状态。用户更新节点数据不能为空")
     private Integer tmp;
     @NotBlank(message = "操作人员id不能为空")
     private Integer author_id;
     @NotBlank(message = "创建时间不能为空")
     private Integer createtime;
     @NotBlank(message = "更新时间不能为空")
     private Integer updatetime;

    @NotBlank(message = "页码不能为空")
    private String page;

    @NotBlank(message = " 一页显示条数不能为空")
    private String limit;






}
