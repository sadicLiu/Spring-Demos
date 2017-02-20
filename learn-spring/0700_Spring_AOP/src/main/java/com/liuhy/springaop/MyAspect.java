package com.liuhy.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by liuhy on 2017/2/19.
 */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before...");
        Object result = invocation.proceed();
        System.out.println("after...");

        return result;
    }
}
