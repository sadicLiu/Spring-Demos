[TOC]

# AspectJ learning notes

## 介绍

- AspectJ是一个基于Java语言的AOP框架
- Spring2.0以后新增了对AspectJ切点表达式支持
- `@AspectJ` 是AspectJ1.5新增功能，通过JDK5注解技术，允许直接在Bean类中定义切面
- 主要用途：自定义开发，如：在不破坏别人代码的前提下，加入自己的代码

## 切入点表达式(用在spring配置文件中)

1. `execution()` 用于描述方法

  - 语法：`execution(修饰符 返回值 包.类.方法名(参数) throws异常)`

    1. 修饰符，一般省略<br>
      `public` 公共方法<br>
      `*` 任意
    2. 返回值，不能省略<br>
      `void` 返回没有值<br>
      `String` 返回值字符串<br>
      `*` 任意
    3. 包，[省略]<br>
      `com.liuhy.crm` 固定包<br>
      `com.liuhy.crm.*.service` crm包下面子包任意 （例如：`com.liuhy.crm.staff.service`）<br>
      `com.liuhy.crm..` crm包下面的所有子包（含自己）<br>
      `com.liuhy.crm.*.service..` crm包下面任意子包，固定目录service，service目录任意包
    4. 类，[省略]<br>
      `UserServiceImpl` 指定类<br>
      `*Impl` 以Impl结尾<br>
      `User*` 以User开头 `*` 任意
    5. 方法名，不能省略<br>
      `addUser` 固定方法<br>
      `add*` 以add开头 `*Do` 以Do结尾<br>
      `*` 任意
    6. (参数)<br>
      `()` 无参<br>
      `(int)` 一个整型<br>
      `(int ,int)` 两个<br>
      `(..)` 参数任意
    7. `throws` ,可省略，一般不写。

  - 多个表达式

    ```
    <aop:pointcut expression="execution(* com.liuhy.*WithCommit.*(..)) ||
     execution(* com.liuhy.*Service.*(..))" id="myPointCut"/>
    ```

2. `within`:匹配包或子包中的方法(了解)<br>
  `within(com.itheima.aop..*)`

3. `this`:匹配实现接口的代理对象中的方法(了解)<br>
  `this(com.itheima.aop.user.UserDAO)`

4. `target`:匹配实现接口的目标对象中的方法(了解) `target(com.itheima.aop.user.UserDAO)`

5. `args`:匹配参数格式符合标准的方法(了解)<br>
  `args(int,int)`

6. `bean(id)` 对指定的bean所有的方法(了解)<br>
  `bean('userServiceId')`

## AspectJ 通知类型

1. before:前置通知(应用：各种校验)<br>
  在方法执行前执行，如果通知抛出异常，阻止方法运行
2. afterReturning:后置通知(应用：常规数据处理)<br>
  方法正常返回后执行，如果方法中抛出异常，通知无法执行 必须在方法执行后才执行，所以可以获得方法的返回值。
3. around:环绕通知(应用：十分强大，可以做任何事情)<br>
  方法执行前后分别执行，可以阻止方法的执行 必须手动执行目标方法
4. afterThrowing:抛出异常通知(应用：包装异常信息)<br>
  方法抛出异常后执行，如果方法没有抛出异常，无法执行
5. after:最终通知(应用：清理现场)<br>
  方法执行完毕后执行，无论方法中是否出现异常

```
环绕
try{
     //前置：before
    //手动执行目标方法
    //后置：afterRetruning
} catch(){
    //抛出异常 afterThrowing
} finally{
    //最终 after
}
```

## 使用AspectJ提供的接口定义切面并配置到Spring

- 导入jar包：aopappliance、aspectj.weaver、spring-aop、spring-aspects

### XML形式实现

> 0800_AspectJ_AOP

1. 目标类：UserService + UserServiceImpl
2. 切面类：MyAspect

  ```
  public void myBefore(JoinPoint joinPoint) {
  System.out.println("前置通知 ： " + joinPoint.getSignature().getName());
  }

  public void myAfterReturning(JoinPoint joinPoint, Object ret) {
  System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->" + ret);
  }

  public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
  System.out.println("前");
  //手动执行目标方法
  Object obj = joinPoint.proceed();

  System.out.println("后");
  return obj;
  }

  public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
  System.out.println("抛出异常通知 ： " + e.getMessage());
  }

  public void myAfter(JoinPoint joinPoint) {
  System.out.println("最终通知");
  }
  ```

3. 配置文件

  ```
  <!-- 1 创建目标类 -->
  <bean id="userService" class="com.liuhy.aspectj.UserServiceImpl"></bean>
  <!-- 2 创建切面类（通知） -->
  <bean id="myAspect" class="com.liuhy.aspectj.MyAspect"></bean>
  <!-- 3 aop编程
  <aop:aspect> 将切面类 声明“切面”，从而获得通知（方法）
   ref 切面类引用
  <aop:pointcut> 声明一个切入点，所有的通知都可以使用。
   expression 切入点表达式
   id 名称，用于其它通知引用
  -->
  <aop:config>
  <aop:aspect ref="myAspect">
   <aop:pointcut expression="execution(* com.liuhy.aspectj.UserServiceImpl.*(..))" id="myPointCut"/>

   <!-- 3.1 前置通知
       <aop:before method="" pointcut="" pointcut-ref=""/>
           method : 通知，及方法名
           pointcut :切入点表达式，此表达式只能当前通知使用。
           pointcut-ref ： 切入点引用，可以与其他通知共享切入点。
       通知方法格式：public void myBefore(JoinPoint joinPoint){
           参数1：org.aspectj.lang.JoinPoint  用于描述连接点（目标方法），获得目标方法名等
       例如：
   <aop:before method="myBefore" pointcut-ref="myPointCut"/>
   -->

   <!-- 3.2后置通知  ,目标方法后执行，获得返回值
       <aop:after-returning method="" pointcut-ref="" returning=""/>
           returning 通知方法第二个参数的名称
       通知方法格式：public void myAfterReturning(JoinPoint joinPoint,Object ret){
           参数1：连接点描述
           参数2：类型Object，参数名 returning="ret" 配置的
       例如：
   <aop:after-returning method="myAfterReturning" pointcut-ref="myPointCut" returning="ret" />
   -->

   <!-- 3.3 环绕通知
       <aop:around method="" pointcut-ref=""/>
       通知方法格式：public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
           返回值类型：Object
           方法名：任意
           参数：org.aspectj.lang.ProceedingJoinPoint
           抛出异常
       执行目标方法：Object obj = joinPoint.proceed();
       例如：
   <aop:around method="myAround" pointcut-ref="myPointCut"/>
   -->
   <!-- 3.4 抛出异常
       <aop:after-throwing method="" pointcut-ref="" throwing=""/>
           throwing ：通知方法的第二个参数名称
       通知方法格式：public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
           参数1：连接点描述对象
           参数2：获得异常信息，类型Throwable ，参数名由throwing="e" 配置
       例如：
   <aop:after-throwing method="myAfterThrowing" pointcut-ref="myPointCut" throwing="e"/>
   -->
   <!-- 3.5 最终通知 -->
   <aop:after method="myAfter" pointcut-ref="myPointCut"/>
  </aop:aspect>
  </aop:config>
  ```

### 注解形式实现

> 0900_AspectJ_AOP_Annotation

1. Spring配置文件

  ```
  <context:component-scan base-package="com.liuhy.aspectj"/>
  <aop:aspectj-autoproxy/>
  ```

2. aop注解总结

  - `@Aspect` 声明切面，修饰切面类

    1. `@Before` 前置
    2. `@AfterReturning` 后置
    3. `@Around` 环绕
    4. `@AfterThrowing` 抛出异常
    5. `@After` 最终

  - 切入点 `@PointCut` ，修饰方法 private void xxx(){} 之后通过"方法名"获得切入点引用
