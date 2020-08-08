package org.myspringframework.aop.aspect;

import java.lang.reflect.Method;

public abstract class DefaultAspect {

    /**
     *
     * @param targetClass 被代理的目标类
     * @param method 被代理的的目标方法
     * @param args 被代理的的目标参数
     * @throws Throwable
     */
    public void Before(Class<?> targetClass, Method method,Object []args) throws Throwable{

    }

    public Object AfterReturning(Class<?> targetClass, Method method,Object []args,Object returnValue) throws Throwable{

        return returnValue;
    }

    public void AfterThrowing(Class<?> targetClass, Method method,Object []args,Throwable e) throws Throwable{


    }

}
