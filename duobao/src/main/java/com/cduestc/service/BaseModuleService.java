package com.cduestc.service;

import com.baomidou.mybatisplus.service.IService;
import com.cduestc.common.beans.HyResult;
import com.cduestc.service.entity.module.entity.BaseModule;
import com.cduestc.service.entity.module.entity.param.ModuleParam;
import com.cduestc.service.entity.module.entity.vo.ModuleVo;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
public interface BaseModuleService extends IService<BaseModule> {


    /**
     * 逻辑删除   isdel  是否删除。1是0否
     * @param param
     * @throws Exception
     */
    HyResult deleteBaseModulById(ModuleParam param)throws Exception;




    HyResult select(ModuleVo moduleVo) throws Exception;
}
