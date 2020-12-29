package com.huilong.chapter1.aspect;

import com.huilong.chapter1.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 我的切面例子
 * <p>
 * 通知顺序  @Around > @Before >  @After >  @AfterReturning > @AfterThrowing
 *
 * @author daocr
 * @date 2020/12/28
 */
@Slf4j
public class MyAspect {

    public MyAspect() {
        log.info("MyAspect 初始化完成");
    }


    /**
     * 前置通知
     */

    public void before(LogAspect logAspect) {

        log.info("触发前置通知（Before） {}", logAspect);
    }

    /**
     * 前置通知
     */
    public void after(LogAspect logAspect) {
        log.info("触发后置通知（After） {}", logAspect);
    }

    /**
     * 后置通知
     */
    public void afterReturning(LogAspect logAspect, Object retVal) {
        log.info("触发后置通知 （AfterReturning） {}", logAspect);
    }

    /**
     * 异常通知
     */
    public void afterThrowing(LogAspect logAspect, Exception ex) {
        log.info("触发异常通知（） {AfterThrowing}", logAspect);
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public void around(ProceedingJoinPoint pjp, LogAspect logAspect) throws Throwable {
        log.info("开始触发环绕通知（Around） {}", logAspect);
        pjp.proceed();
        log.info("结束触发环绕通知（Around） {}", logAspect);
    }


}
