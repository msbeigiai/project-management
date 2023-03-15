package com.msbeigi.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "within(com.msbeigi.pma.controllers..*)"
            + "|| within(com.msbeigi.pma.dao..*)")
    public void definePackagePointCuts() {

    }

    @Around("definePackagePointCuts()")
    public Object logAround(ProceedingJoinPoint jp) {

        logger.debug("\n\n\n");
        logger.debug("******* Before Method Execution ******* \n {}.{} () with arguments [s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));

        logger.debug("__________________________________\n\n\n");

        Object o = null;
        try {
            o = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        logger.debug("\n\n\n");
        logger.debug("******* After Method Execution ******* \n {}.{} () with arguments [s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));

        logger.debug("__________________________________\n\n\n");

        return o;
    }

}
