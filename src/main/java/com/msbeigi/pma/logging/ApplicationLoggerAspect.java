package com.msbeigi.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "within(com.msbeigi.pma.controllers..*)"
            + "|| within(com.msbeigi.pma.dao..*)")
    public void definePackagePointCuts() {

    }

    @Before("definePackagePointCuts()")
    public void log() {
        logger.debug("----------------------");
    }

}
