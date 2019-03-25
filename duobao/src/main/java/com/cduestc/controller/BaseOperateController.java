package com.cduestc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseOperateService;
import com.cduestc.service.entity.dictionary.entity.BaseDictionary;
import com.cduestc.service.entity.dictionary.entity.vo.DictionaryVo;
import com.cduestc.service.entity.module.entity.param.ModulePage;
import com.cduestc.service.entity.operate.entity.BaseOperate;
import com.cduestc.service.entity.operate.entity.param.OperateParam;
import com.cduestc.service.entity.operate.entity.vo.OperateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/admin/v1.0")
public class BaseOperateController {


    @Autowired
    private BaseOperateService baseOperateService;

    @ResponseBody
    @RequestMapping(value = "/operate/del",method = RequestMethod.POST)
    public HyResult userLogin(@RequestBody OperateParam param)throws Exception{

        if(param.getId() == null || "".equals(param.getId())){
            return new HyResult("参数不合法",BeansEnum.ERROR.getCode(),"",0);
        }
        HyResult response= baseOperateService.deleteBaseOperateById(param);
        return response;
    }
    @ResponseBody
    @RequestMapping(value = "/operate",method = RequestMethod.POST)
    public HyResult select(@RequestBody ModulePage page)throws Exception{
        /*  List<Employee> employees = emplopyeeDao.selectPage(new Page<>(1,2),null);  */
        Map<String, Object> map1 =new HashMap<String, Object>();
        Map<String, Object>  map2 =new HashMap<String, Object>();
        Wrapper<BaseOperate> wrapper=new EntityWrapper<>();
        List<BaseOperate> baseOperateList = baseOperateService.selectList(wrapper);
        for (BaseOperate baseOperate : baseOperateList) {
            map1.put("rows",baseOperate);
        }
        map2.putAll(map1);
        System.out.println(map2);
        HyResult response= baseOperateService.select(page);
        return response;
    }

    /**
     * 添加/修改-->操作
     *
     * @param session
     * @param
     * @return
     */
    @RequestMapping(value = "operate/edit", method = RequestMethod.POST)
    @ResponseBody
    public HyResult addUser(HttpSession session, @RequestBody OperateVo operateVo) {

        BaseOperate baseOperate = new BaseOperate();
        if (operateVo.getId() != null || "".equals(operateVo.getId())) {// id不为空   编辑
            baseOperate.setId(Integer.parseInt(operateVo.getId()));
            baseOperate.setUpdatetime(DateUtil.getTimeStamp());
            BeanUtils.copyProperties(operateVo, baseOperate);
            boolean flag = baseOperateService.updateById(baseOperate);
            if (flag) {
                return HyResult.SUCCESS("编辑成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("编辑失败！", BeansEnum.ERROR.getCode(), "", 1);
        } else {   //  id为空    新增
            BeanUtils.copyProperties(operateVo, baseOperate);
            baseOperate.setCreatetime(DateUtil.getTimeStamp());
            BaseOperate operate = baseOperateService.selectOne(new EntityWrapper<>(baseOperate));
            if (operate != null) {
                return HyResult.FAIL("操作已存在！", BeansEnum.ERROR.getCode(), "", 1);
            }
            System.out.println(baseOperate);
            boolean flag = baseOperateService.insert(baseOperate);
            if (flag) {
                return HyResult.SUCCESS("添加成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("添加失败！", BeansEnum.ERROR.getCode(), "", 1);
        }
    }

}

