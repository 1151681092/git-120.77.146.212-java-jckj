package com.cduestc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseRoleService;
import com.cduestc.service.dao.BaseRoleMapper;
import com.cduestc.service.entity.role.entity.BaseRole;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseRoleResquestDTO;
import com.cduestc.service.entity.role.entity.param.RoleParam;
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
public class BaseRoleServiceImpl extends ServiceImpl<BaseRoleMapper, BaseRole> implements BaseRoleService {

    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Override
    public HyResult deleteBaseOperateById(RoleParam param) throws Exception {

        //先查询该模块是否已经删除
        BaseRole baseRole = new BaseRole();
        baseRole.setId(param.getId());
        baseRole.setIsdel(0);

        BaseRole baseOperate1 = baseRoleMapper.selectOne(baseRole);
        System.out.println(baseOperate1+"-------------------------");
        if ( StringUtils.isEmpty(baseOperate1)) {
            return new HyResult("删除失败",BeansEnum.DELETE_NO.getCode(),"",0);
        }

        //传参
        baseRole.setIsdel(1);
        baseRole.setUpdatetime(new DateUtil().getTimeStamp());
        //删除
        baseRoleMapper.updateById(baseRole);
        return new HyResult("删除成功",BeansEnum.DELETE_OK.getCode(),"",1);
    }
}
