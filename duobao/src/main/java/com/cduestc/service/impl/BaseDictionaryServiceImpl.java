package com.cduestc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cduestc.common.beans.BeansEnum;
import com.cduestc.common.beans.HyResult;
import com.cduestc.common.utils.DateUtil;
import com.cduestc.service.BaseDictionaryService;
import com.cduestc.service.dao.BaseDictionaryMapper;
import com.cduestc.service.entity.dictionary.entity.BaseDictionary;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseDictionnaryResquestDTO;
import com.cduestc.service.entity.dictionary.entity.param.DictionaryParam;
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
public class BaseDictionaryServiceImpl extends ServiceImpl<BaseDictionaryMapper, BaseDictionary> implements BaseDictionaryService {

    @Autowired
    private BaseDictionaryMapper dictionaryMapper;

    @Override
    public HyResult deleteBaseDictionaryById(DictionaryParam param) throws Exception {

        //先查询该模块是否已经删除
        BaseDictionary baseDictionary = new BaseDictionary();
        baseDictionary.setId(param.getId());
        baseDictionary.setIsdel(0);

        BaseDictionary baseModule1 = dictionaryMapper.selectOne(baseDictionary);
        System.out.println(baseModule1+"-------------------------");
        if ( StringUtils.isEmpty(baseModule1)) {
            return new HyResult("删除失败",BeansEnum.DELETE_NO.getCode(),"",0);
        }

        //传参
        baseDictionary.setIsdel(1);
        baseDictionary.setUpdatetime(new DateUtil().getTimeStamp());
        //删除
        dictionaryMapper.updateById(baseDictionary);
        return new HyResult("删除成功",BeansEnum.DELETE_OK.getCode(),"",1);
    }
}
