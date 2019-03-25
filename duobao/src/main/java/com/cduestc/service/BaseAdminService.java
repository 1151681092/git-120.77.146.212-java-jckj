package com.cduestc.service;


import com.baomidou.mybatisplus.service.IService;
import com.cduestc.common.beans.HyResult;
import com.cduestc.service.entity.admin.entity.BaseAdmin;
import com.cduestc.service.entity.ResquestDTO.UpdateStatusResquestDTO;
import com.cduestc.service.entity.admin.entity.param.AdminParam;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-20
 */
public interface BaseAdminService extends IService<BaseAdmin> {

    /**
     * 用户登录接口
     * @param param
     * @return
     */
    HyResult selectUserByUserName(AdminParam param) throws Exception;

    /**
     * 管理员停用/启用
     */
    HyResult updateStatusById(UpdateStatusResquestDTO statusResquestDTO)throws Exception;

}
