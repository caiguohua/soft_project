package com.net.soft.utils;

import com.net.soft.common.ResultVO;

/** HTTP接口的结果处理工具类
 * @author caiguohua
 * @date 2020/2/27 12:07
 * @Email:cai.beyond@qq.com
 */
public class ResultUtil {
    public static ResultVO successResult(Object o){
        return new ResultVO(0,"success",o);
    }
    public static ResultVO errorResult(Integer code,String message,Object o){
        return new ResultVO(code,message,o);
    }
}
