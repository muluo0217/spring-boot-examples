package indi.zhaosheng.logaop.aop;

import com.alibaba.fastjson.JSON;
import indi.zhaosheng.logaop.annotation.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author muluo
 * @description
 * @date 2020/5/16 10:35
 */
@Aspect
@Component
public class LogServiceAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogServiceAspect.class);

    @Pointcut("@annotation(indi.zhaosheng.logaop.annotation.LogService)")
    public void log() {
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("========================调用开始===========================");
        logger.info("[调用类名]:{},[方法名]:{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        String reqParam = JSON.toJSONString(joinPoint.getArgs());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogService logService = methodSignature.getMethod().getAnnotation(LogService.class);
        logger.info("[调用说明]:{}", logService.value());
        logger.info("[调用参数]:{}", reqParam);
        Object[] args = joinPoint.getArgs();
        Object retVal = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        logger.info("[调用耗时]:{}毫秒", (endTime - startTime));
        logger.info("========================调用结束===========================");
        return retVal;
    }
}
