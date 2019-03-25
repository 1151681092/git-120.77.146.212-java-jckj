package com.cduestc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseOperateService;
import com.cduestc.service.dao.BaseOperateMapper;
import com.cduestc.service.entity.operate.entity.BaseOperate;
import com.cduestc.service.entity.module.entity.param.ModulePage;
import com.cduestc.service.entity.operate.entity.param.OperateParam;
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
public class BaseOperateServiceImpl extends ServiceImpl<BaseOperateMapper, BaseOperate> implements BaseOperateService {

    @Autowired
    private BaseOperateMapper baseOperateMapper;

    @Override
    public HyResult deleteBaseOperateById(OperateParam param) throws Exception {

        //先查询该模块是否已经删除
        BaseOperate baseOperatease = new BaseOperate();
        baseOperatease.setId(param.getId());
        baseOperatease.setIsdel(0);

        BaseOperate baseOperate1 = baseOperateMapper.selectOne(baseOperatease);
        System.out.println(baseOperate1+"-------------------------");
        if ( StringUtils.isEmpty(baseOperate1)) {
            return new HyResult("删除失败",BeansEnum.DELETE_NO.getCode(),"",0);
        }

        //传参
        baseOperatease.setIsdel(1);
        baseOperatease.setUpdatetime(new DateUtil().getTimeStamp());
        //删除
        baseOperateMapper.updateById(baseOperatease);
        return new HyResult("删除成功",BeansEnum.DELETE_OK.getCode(),"",1);
    }

    @Override
    public HyResult select(ModulePage page) throws Exception {
        BaseOperate baseOperate=new BaseOperate();

        String module = baseOperate.getModule();


        return new HyResult("查询成功",BeansEnum.DELETE_OK.getCode(),"",1);
    }
}
