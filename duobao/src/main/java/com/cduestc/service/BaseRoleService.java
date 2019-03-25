package com.cduestc.service;

import com.baomidou.mybatisplus.service.IService;
import com.cduestc.common.beans.HyResult;
import com.cduestc.service.entity.role.entity.BaseRole;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseRoleResquestDTO;
import com.cduestc.service.entity.role.entity.param.RoleParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
public interface BaseRoleService extends IService<BaseRole> {


    /**
     * 逻辑删除   isdel  是否删除。1是0否
     * @param param
     * @throws Exception
     */
    HyResult deleteBaseOperateById(RoleParam param)throws Exception;
}
