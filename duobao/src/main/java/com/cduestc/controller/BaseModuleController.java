package com.cduestc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseModuleService;
import com.cduestc.service.entity.module.entity.param.ModuleParam;
import com.cduestc.service.entity.module.entity.vo.ModuleVo;
import com.cduestc.service.entity.module.entity.BaseModule;
import com.cduestc.service.entity.operate.entity.BaseOperate;
import com.cduestc.service.entity.operate.entity.vo.OperateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/admin/v1.0")
public class BaseModuleController {


    @Autowired
    private BaseModuleService baseModuleService;

    @ResponseBody
    @RequestMapping(value = "/module/del",method = RequestMethod.POST)
    public HyResult userLogin(@RequestBody @Validated ModuleParam param)throws Exception{


        if(param.getId() == null || "".equals(param.getId()) ){
            return new HyResult("参数不合法",BeansEnum.ERROR.getCode(),"",0);
        }
        HyResult response= baseModuleService.deleteBaseModulById(param);
        return response;
    }



    @RequestMapping(value ="/module",method = RequestMethod.POST)
    @ResponseBody
    public HyResult select(@RequestBody @Validated ModuleVo moduleVo) throws Exception{
        /*Map<String, Object>*/

        Map<String, Object> map1 =new HashMap<String, Object>();
        Map<String, Object>  map2 =new HashMap<String, Object>();
        Map<String, Object>  map3 =new HashMap<String, Object>();
        Map<Object,Map<String,Object>> map= new HashMap<>();
        Wrapper<BaseModule> wrapper=new EntityWrapper<BaseModule>();


        Page<BaseModule> page= new Page<>();
        Page<BaseModule> baseModulePage = baseModuleService.selectPage(page);
        System.out.println("baseModulePage"+baseModulePage);
        int pages = baseModulePage.getPages();
        int size = baseModulePage.getSize();
        List<BaseModule> baseModuleList = baseModuleService.selectList(wrapper);
        for (BaseModule baseModule : baseModuleList) {
            map1.put("rows",baseModule);

        }

        map2.put("data",map1);
        System.out.println(map2);
        HyResult response= baseModuleService.select(moduleVo);


        return response;
    }

    /**
     * 添加/修改系统模块
     *
     * @param session
     * @param
     * @return
     */
    @RequestMapping(value = "module/edit", method = RequestMethod.POST)
    @ResponseBody
    public HyResult addUser(HttpSession session, @RequestBody ModuleParam moduleParam) {

        BaseModule baseModule = new BaseModule();
        if (moduleParam.getId() != null || "".equals(moduleParam.getId())) {// id不为空   编辑
            moduleParam.setId(Integer.parseInt(moduleParam.getId()));
            moduleParam.setUpdatetime(DateUtil.getTimeStamp());
            BeanUtils.copyProperties(moduleParam, baseModule);
            boolean flag = baseModuleService.updateById(baseModule);
            if (flag) {
                return HyResult.SUCCESS("修改成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("修改失败！", BeansEnum.ERROR.getCode(), "", 1);
        } else {   //  id为空    新增
            BeanUtils.copyProperties(moduleParam, baseModule);
            baseModule.setCreatetime(DateUtil.getTimeStamp());
            BaseModule module = baseModuleService.selectOne(new EntityWrapper<>(baseModule));
            if (module != null) {
                return HyResult.FAIL("模块已存在！", BeansEnum.ERROR.getCode(), "", 1);
            }
            System.out.println(baseModule);
            boolean flag = baseModuleService.insert(baseModule);
            if (flag) {
                return HyResult.SUCCESS("添加成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("添加失败！", BeansEnum.ERROR.getCode(), "", 1);
        }
    }



}

