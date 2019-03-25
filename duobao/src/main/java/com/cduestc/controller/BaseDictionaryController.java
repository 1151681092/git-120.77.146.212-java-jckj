package com.cduestc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseDictionaryService;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseDictionnaryResquestDTO;
import com.cduestc.service.entity.admin.entity.BaseAdmin;
import com.cduestc.service.entity.admin.entity.vo.AdminVo;
import com.cduestc.service.entity.dictionary.entity.BaseDictionary;
import com.cduestc.service.entity.dictionary.entity.param.DictionaryParam;
import com.cduestc.service.entity.dictionary.entity.vo.DictionaryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
public class BaseDictionaryController {

    @Autowired
    private BaseDictionaryService baseDictionaryService;

    @ResponseBody
    @RequestMapping(value = "/dictionary/del",method = RequestMethod.POST)
    public HyResult userLogin(@RequestBody DictionaryParam param)throws Exception{

        if(param.getId() == null || "".equals(param.getId())){
            return new HyResult("参数不合法",BeansEnum.ERROR.getCode(),"",0);
        }
        HyResult response= baseDictionaryService.deleteBaseDictionaryById(param);
        return response;
    }

    /**
     * 添加/修改数据字典
     *
     * @param session
     * @param
     * @return
     */
    @RequestMapping(value = "dictionary/edit", method = RequestMethod.POST)
    @ResponseBody
    public HyResult addUser(HttpSession session, @RequestBody DictionaryVo dictionaryVo) {

        BaseDictionary baseDictionary = new BaseDictionary();
        if (dictionaryVo.getId() != null || "".equals(dictionaryVo.getId())) {// id不为空   编辑
            baseDictionary.setId(Integer.parseInt(dictionaryVo.getId()));
            baseDictionary.setUpdatetime(DateUtil.getTimeStamp());
            BeanUtils.copyProperties(dictionaryVo, baseDictionary);
            boolean flag = baseDictionaryService.updateById(baseDictionary);
            if (flag) {
                return HyResult.SUCCESS("编辑成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("编辑失败！", BeansEnum.ERROR.getCode(), "", 1);
        } else {   //  id为空    新增
            BeanUtils.copyProperties(dictionaryVo, baseDictionary);
            baseDictionary.setCreatetime(DateUtil.getTimeStamp());
            BaseDictionary dictionary = baseDictionaryService.selectOne(new EntityWrapper<>(baseDictionary));
            if (dictionary != null) {
                return HyResult.FAIL("数据字典已存在！", BeansEnum.ERROR.getCode(), "", 1);
            }
            System.out.println(baseDictionary);
            boolean flag = baseDictionaryService.insert(baseDictionary);
            if (flag) {
                return HyResult.SUCCESS("添加成功！", BeansEnum.SUCCESS.getCode(), "", 1);
            }
            return HyResult.FAIL("添加失败！", BeansEnum.ERROR.getCode(), "", 1);
        }
    }

}

