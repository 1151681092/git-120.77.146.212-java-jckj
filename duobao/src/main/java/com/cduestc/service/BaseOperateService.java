package com.cduestc.service;

import com.baomidou.mybatisplus.service.IService;
import com.cduestc.common.beans.HyResult;
import com.cduestc.service.entity.operate.entity.BaseOperate;
import com.cduestc.service.entity.module.entity.param.ModulePage;
import com.cduestc.service.entity.operate.entity.param.OperateParam;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
public interface BaseOperateService extends IService<BaseOperate> {

    /**
     * 逻辑删除   isdel  是否删除。1是0否
     * @param param
     * @throws Exception
     */
    HyResult deleteBaseOperateById(OperateParam param)throws Exception;

    HyResult select(ModulePage page) throws Exception;
}
