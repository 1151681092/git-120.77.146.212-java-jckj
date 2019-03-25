package com.cduestc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseAdminService;
import com.cduestc.service.dao.BaseAdminMapper;
import com.cduestc.service.entity.admin.entity.BaseAdmin;
import com.cduestc.service.entity.ResquestDTO.UpdateStatusResquestDTO;
import com.cduestc.service.entity.admin.entity.param.AdminParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.cduestc.common.utils.AESUtil.AESEncode;

/**
 *
 * @author caozhiheng
 * @since 2019-03-20
 */
@Service("baseAdminService")
public class BaseAdminServiceImpl extends ServiceImpl<BaseAdminMapper, BaseAdmin> implements BaseAdminService {

    @Autowired
    private BaseAdminMapper baseAdminMapper;
    /**
     * 用户登录接口 Service层
     * @param param
     * @return
     */
    public HyResult selectUserByUserName(AdminParam param) throws Exception {


        //查看是否有该数据
        BaseAdmin baseAdmin = new BaseAdmin();
        baseAdmin.setUsername(param.getUsername());            //账号
        baseAdmin.setPassword(AESEncode(param.getPassword())); //密码
        baseAdmin.setStatus(1);                                  //'状态。1启用0停用'
        baseAdmin.setIsdel(0);                                   //'是否删除。1是0否'

        BaseAdmin baseAdmin1 = baseAdminMapper.selectOne(baseAdmin);

        if (StringUtils.isEmpty(baseAdmin1)) {
            return new HyResult("账号或者密码不正确",BeansEnum.SUCCESS.getCode(),"",1);
        }
        return new HyResult("",BeansEnum.SUCCESS.getCode(),"",1);

    }

    /**
     * 停用/启用
     * @param statusResquestDTO
     * @return
     * @throws Exception
     */
    @Override
    public HyResult updateStatusById(UpdateStatusResquestDTO statusResquestDTO) throws Exception {

        /**
         * 查询账号信息
         */
        BaseAdmin baseAdmin = new BaseAdmin();
        baseAdmin.setId(statusResquestDTO.getId());
        baseAdmin.setIsdel(0);   //确认该账号没有被删除
        BaseAdmin baseAdmin1 = baseAdminMapper.selectOne(baseAdmin);
        if(StringUtils.isEmpty(baseAdmin1)){
            return new HyResult("账号不存在",BeansEnum.ERROR.getCode(),"",0);
        }
        System.out.println(baseAdmin1.getStatus());
        switch (baseAdmin1.getStatus()){

            //状态已启用
            case 1:
                baseAdmin.setStatus(0);
                baseAdmin.setUpdatetime(new DateUtil().getTimeStamp());
                //停用该账号
                baseAdminMapper.updateById(baseAdmin);
                break;
            case 0:
                baseAdmin.setStatus(1);
                baseAdmin.setUpdatetime(new DateUtil().getTimeStamp());
                //启用该账号
                baseAdminMapper.updateById(baseAdmin);
                break;
        }

        return new HyResult("",BeansEnum.SUCCESS.getCode(),"",1);
    }

}
