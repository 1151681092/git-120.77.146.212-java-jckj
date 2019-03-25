package com.cduestc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseModuleService;
import com.cduestc.service.dao.BaseModuleMapper;
import com.cduestc.service.entity.module.entity.BaseModule;
import com.cduestc.service.entity.module.entity.param.ModuleParam;
import com.cduestc.service.entity.module.entity.vo.ModuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
@Service
public class BaseModuleServiceImpl extends ServiceImpl<BaseModuleMapper, BaseModule> implements BaseModuleService {

    @Autowired
    private BaseModuleMapper baseModuleMapper;

    /**
     * 逻辑删除   模块删除
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public HyResult deleteBaseModulById(ModuleParam param) throws Exception {

        //先查询该模块是否已经删除
        BaseModule baseModule = new BaseModule();
        baseModule.setId(param.getId());
        baseModule.setIsdel(0);

        BaseModule baseModule1 = baseModuleMapper.selectOne(baseModule);
        System.out.println(baseModule1+"-------------------------");
        if ( StringUtils.isEmpty(baseModule1)) {
            return new HyResult("删除失败",BeansEnum.DELETE_NO.getCode(),"",0);
        }

        //传参
        baseModule.setIsdel(1);
        baseModule.setUpdatetime(new DateUtil().getTimeStamp());
        //删除
        baseModuleMapper.updateById(baseModule);
        return new HyResult("删除成功",BeansEnum.DELETE_OK.getCode(),"",1);
    }


    @Override
    public HyResult select(ModuleVo moduleVo) throws Exception {
        BaseModule baseModule=new BaseModule();
        baseModule.setPid(moduleVo.getPid());
        baseModule.setTitle(moduleVo.getTitle());

        return new HyResult("正确", BeansEnum.SUCCESS.getCode(),"",1);
    }
}
