package indi.zhaosheng.logaop.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author muluo
 * @description
 * @date 2020/5/16 10:18
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * indi.zhaosheng.logaop.rest.*Controller.*(..))")
    public void log(){}

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        logger.info("========================请求开始===========================");
        logger.info("[请求IP]:{}", request.getRemoteAddr());
        logger.info("[请求URL]:{}", request.getRequestURL());
        logger.info("[请求方式]:{}", request.getMethod());
        logger.info("[请求类名]:{},[请求方法名]:{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        String reqParam = RequestMethod.GET.name().equals(request.getMethod()) ?
                JSON.toJSONString(request.getParameterMap()) : JSON.toJSONString(joinPoint.getArgs());
        logger.info("[请求参数]:{}", reqParam);
        Object[] args = joinPoint.getArgs();
        Object retVal;
        try {
            retVal = joinPoint.proceed(args);
        } catch (Throwable e){
            logger.info("========================请求发生异常===========================");
            long endTime = System.currentTimeMillis();
            logger.info("[请求耗时]:{}毫秒", (endTime-startTime));
            logger.info("========================请求结束===========================");
            throw e;
        }
        long endTime = System.currentTimeMillis();
        logger.info("[请求耗时]:{}毫秒", (endTime-startTime));
        logger.info("========================请求结束===========================");
        return retVal;
    }
}
