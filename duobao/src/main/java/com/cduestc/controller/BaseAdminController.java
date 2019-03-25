package com.cduestc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseAdminService;
import com.cduestc.service.entity.ResquestDTO.UpdateStatusResquestDTO;
import com.cduestc.service.entity.admin.entity.BaseAdmin;
import com.cduestc.service.entity.admin.entity.param.AdminParam;
import com.cduestc.service.entity.admin.entity.vo.AdminVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.cduestc.common.utils.AESUtil.AESEncode;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/admin/v1.0")
public class BaseAdminController {

    @Autowired
    private BaseAdminService baseAdminService;


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HyResult userLogin(HttpSession session, @RequestBody AdminParam param) throws Exception {

        HyResult response = baseAdminService.selectUserByUserName(param);
        if (!StringUtils.isEmpty(response)) {
            session.setAttribute("username", param.getUsername());
            session.setAttribute("password", AESEncode(param.getPassword()));
        }
        System.out.println(response.toString());
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "admin/updateStatus", method = RequestMethod.POST)
    public HyResult updateStatus(@RequestBody @Validated UpdateStatusResquestDTO resquest) throws Exception {

        HyResult HYResult = baseAdminService.updateStatusById(resquest);
        return HYResult;
    }

    /**
     * 添加/修改管理员信息
     *
     * @param session
     * @param
     * @return
     */
    @RequestMapping(value = "admin/edit", method = RequestMethod.POST)
    @ResponseBody
    public HyResult addUser(HttpSession session, @RequestBody AdminVo adminVo) {

        BaseAdmin baseAdmin = new BaseAdmin();
        baseAdmin.setStatus(Integer.parseInt(adminVo.getStatus()));
        baseAdmin.setRoleId(Integer.parseInt(adminVo.getRoleId()));
        if (adminVo.getId() != null || "".equals(adminVo.getId())) {// id不为空   编辑
            baseAdmin.setId(Integer.parseInt(adminVo.getId()));
            baseAdmin.setUpdatetime(DateUtil.getTimeStamp());
            BeanUtils.copyProperties(adminVo, baseAdmin);
            boolean flag = baseAdminService.updateById(baseAdmin);
            if (flag) {
                return HyResult.SUCCESS("编辑成功", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("编辑失败！", BeansEnum.ERROR.getCode(), "", 1);
        } else {   //  id为空    新增
            BeanUtils.copyProperties(adminVo, baseAdmin);
            baseAdmin.setCreatetime(DateUtil.getTimeStamp());
            baseAdmin.setUpdatetime(DateUtil.getTimeStamp());
            baseAdmin.setAuthorId(1);
            BaseAdmin admin = baseAdminService.selectOne(new EntityWrapper<>(baseAdmin));
            if (admin != null) {
                return HyResult.FAIL("账号已存在！", BeansEnum.ERROR.getCode(), "", 1);
            }
            System.out.println(baseAdmin);
            boolean flag = baseAdminService.insert(baseAdmin);
            if (flag) {
                return HyResult.SUCCESS("添加成功", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("添加失败！", BeansEnum.ERROR.getCode(), "", 1);
        }
    }

}

