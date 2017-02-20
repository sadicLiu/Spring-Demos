package com.liuhy.springproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by liuhy on 2017/2/19.
 */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("aspect before...");
        Object result = invocation.proceed();
        System.out.println("aspect after...");

        return result;
    }
}
