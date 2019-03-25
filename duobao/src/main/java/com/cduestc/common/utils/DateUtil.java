package com.cduestc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : caozhiheng
 * @Date : 2019/3/2210:43
 * 生成时间戳
 */
public final class DateUtil {

    /**
     * 获取当前时间戳
     * @return
     */
    public static Integer getTimeStamp(){
        Long time = new Date().getTime()/1000;
        return time.intValue();
    }

    /**
     * 时间戳转时间
     * @param timeStamp
     * @return
     */
    public static String getDateTime(Integer timeStamp){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(timeStamp.toString().length() == 10){
            String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp.longValue()*1000))));
            return sd;
        }
        return sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
    }
}
