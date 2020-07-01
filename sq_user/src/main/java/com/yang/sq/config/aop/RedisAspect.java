package com.yang.sq.config.aop;

import com.yang.sq.api.common.exception.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/7/2 0:01
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Aspect
@Configuration
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //是否开启redis缓存  true开启   false关闭
    @Value("${spring.redis.open: false}")
    private boolean open;

    @Around("execution(* com.yang.sq.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception e){
                logger.error("redis error", e);
                throw new BusinessException("Redis服务异常") ;
            }
        }
        return result;
    }
}
