package tn.spring.springboot.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.spring.springboot.service.*.*(..))")
    public  void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterReturning(" execution(* tn.spring.springboot.service.*.add*(..))")
    public void LogMethodShow(JoinPoint joinPoint){
        log.info("Ajouté!");
    }
}