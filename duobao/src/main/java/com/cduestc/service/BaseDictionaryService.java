package com.cduestc.service;

import com.baomidou.mybatisplus.service.IService;
import com.cduestc.common.beans.HyResult;
import com.cduestc.service.entity.dictionary.entity.BaseDictionary;
import com.cduestc.service.entity.ResquestDTO.DeleteBaseDictionnaryResquestDTO;
import com.cduestc.service.entity.dictionary.entity.param.DictionaryParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caozhiheng
 * @since 2019-03-21
 */
public interface BaseDictionaryService extends IService<BaseDictionary> {

    /**
     * 逻辑删除   isdel  是否删除。1是0否
     * @param param
     * @throws Exception
     */
    HyResult deleteBaseDictionaryById(DictionaryParam param)throws Exception;
}
