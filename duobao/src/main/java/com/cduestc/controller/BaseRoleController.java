package com.cduestc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseRoleService;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseRoleResquestDTO;
import com.cduestc.service.entity.module.entity.BaseModule;
import com.cduestc.service.entity.module.entity.param.ModuleParam;
import com.cduestc.service.entity.role.entity.BaseRole;
import com.cduestc.service.entity.role.entity.param.RoleParam;
import com.cduestc.service.entity.role.entity.vo.RoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
@RestController
@RequestMapping("/admin/v1.0")
public class BaseRoleController {

    @Autowired
    private BaseRoleService baseRoleService;

    @ResponseBody
    @RequestMapping(value = "/role/del",method = RequestMethod.POST)
    public HyResult userLogin(@RequestBody RoleParam param)throws Exception{

        if(param.getId() == null || "".equals(param.getId())){
            return new HyResult("参数不合法",BeansEnum.ERROR.getCode(),"",0);
        }
        HyResult response= baseRoleService.deleteBaseOperateById(param);
        return response;
    }


    /**
     * 添加/修改系统模块
     *
     * @param session
     * @param
     * @return
     */
    @RequestMapping(value = "role/edit", method = RequestMethod.POST)
    @ResponseBody
    public HyResult addUser(HttpSession session, @RequestBody RoleVo roleVo) {

        BaseRole baseRole = new BaseRole();
        if (roleVo.getId() != null || "".equals(roleVo.getId())) {// id不为空   编辑
            baseRole.setId(Integer.parseInt(roleVo.getId()));
            baseRole.setUpdatetime(DateUtil.getTimeStamp());
            BeanUtils.copyProperties(roleVo, baseRole);
            boolean flag = baseRoleService.updateById(baseRole);
            if (flag) {
                return HyResult.SUCCESS("修改成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("修改失败！", BeansEnum.ERROR.getCode(), "", 1);
        } else {   //  id为空    新增
            BeanUtils.copyProperties(roleVo, baseRole);
            baseRole.setCreatetime(DateUtil.getTimeStamp());
            BaseRole role = baseRoleService.selectOne(new EntityWrapper<>(baseRole));
            if (role != null) {
                return HyResult.FAIL("角色已存在！", BeansEnum.ERROR.getCode(), "", 1);
            }
            System.out.println(baseRole);
            boolean flag = baseRoleService.insert(baseRole);
            if (flag) {
                return HyResult.SUCCESS("添加成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("添加失败！", BeansEnum.ERROR.getCode(), "", 1);
        }
    }

}

