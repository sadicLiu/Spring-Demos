package com.liuhy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * Created by liuhy on 2017/2/19.
 */
public class MyBeanFactory {

    public static UserService createUserService() {
        // 目标类
        UserService userService = new UserService();

        // 切面类
        MyAspect myAspect = new MyAspect();

        // 代理类
        UserService proxyService = null;

        // 核心类
        Enhancer enhancer = new Enhancer();
        // 确定父类
        enhancer.setSuperclass(userService.getClass());

        /*
        * 设置回调函数，MethodInterceptor接口等效jdk InvocationHandler接口
        *
        *   intercept() 等效 jdk  invoke()
        *       参数1、参数2、参数3：与invoke一样
        *       参数4：methodProxy 方法的代理
        * */
        enhancer.setCallback((MethodInterceptor) (proxy, method, args, methodProxy) -> {

            myAspect.before();

            Object result = method.invoke(userService, args);

            /**
             * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
             * 下面的调用方式和上面等效
             * */
            // methodProxy.invokeSuper(proxy, args);

            myAspect.after();

            return result;
        });

        proxyService = (UserService) enhancer.create();

        return proxyService;
    }
}
