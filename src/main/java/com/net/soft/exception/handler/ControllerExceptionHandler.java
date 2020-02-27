package com.net.soft.exception.handler;

import com.net.soft.exception.RequestFailException;
import com.net.soft.exception.SoftException;
import com.net.soft.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.exceptions.JedisException;

/**
 * controller异常处理器
 * @author caiguohua
 * @date 2020/2/27 15:16
 * @Email:cai.beyond@qq.com
 */
@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * redis异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {JedisException.class})
    @ResponseStatus(value = HttpStatus.OK)
    public Object redisErrorExceptionHandler(Exception e){
        logger.error("[{redisErrorException:}]出现异常：message:[{}]", e.getMessage(),e);
        return ResultUtil.errorResult(-9999,"redis服务异常",null);
    }

    /**
     * 请求接口异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {RequestFailException.class})
    public Object requestFailExceptionHandler(RequestFailException e){
        logger.error("请求接口出现错误：message:[{}],stackTrace:[{}]", e.getMessage(), e.getStackTrace());
        return ResultUtil.errorResult(-2,e.getMessage(),null);
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {SoftException.class})
    public Object softExceptionHandler(SoftException e){
        logger.error("[{softException:}]出现异常：message:[{}],stackTrace:[{}]", e.getMessage(), e.getStackTrace());
        return ResultUtil.errorResult(e.getCode(),e.getMessage(),null);
    }

    /**
     * 其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object defaultExceptionHandler(Exception e){
        logger.error("[{defaultException:}]出现异常： message:[{}],stackTrace:[{}]",e.getMessage(),e.getStackTrace());
        return ResultUtil.errorResult(-1,e.getMessage(),null);
    }
}
