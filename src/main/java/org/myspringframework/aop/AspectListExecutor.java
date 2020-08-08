package org.myspringframework.aop;

import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.myspringframework.aop.aspect.AspectInfo;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AspectListExecutor implements MethodInterceptor {

    //被代理的类
    private Class<?> aClass;

    private List<AspectInfo> aspectInfoList;

    public AspectListExecutor(Class<?> aClass,List<AspectInfo> aspectInfoList){
        this.aClass=  aClass;
        this.aspectInfoList = sortAspectInfo(aspectInfoList);
    }

    private List<AspectInfo> sortAspectInfo(List<AspectInfo> aspectInfoList) {
         aspectInfoList.sort(new Comparator<AspectInfo>() {
             @Override
             public int compare(AspectInfo o1, AspectInfo o2) {
                 return o1.getOrder() - o2.getOrder();
             }
         });
         return aspectInfoList;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnValue = null;
        if(aspectInfoList==null||aspectInfoList.size()==0)
            return returnValue;

        //1.按照升序执行Before方法
        invokeBeforeAdvice(method,args);
        //2.执行被代理类的方法
        try {
            returnValue = methodProxy.invokeSuper(o,args);
            //3.如果代理类正常返回则降序执行AfterReturning方法
            returnValue =  invokeAfterReturning(method,args,returnValue);

        } catch (Exception e){
            //4.如果代理类抛出异常则降序执行AfterThrowing方法
            invokeAfterThrowing(method,args,e);
        }





        return returnValue;
    }

    private void invokeAfterThrowing(Method method, Object[] args, Exception e) throws Throwable {
        for(int i = aspectInfoList.size()-1;i>=0;i--){
            aspectInfoList.get(i).getDefaultAspect().AfterThrowing(aClass,method,args,e);
        }

    }

    private Object invokeAfterReturning( Method method, Object[] args, Object returnValue) throws Throwable {
        for(int i = aspectInfoList.size()-1;i>=0;i--){
            returnValue =aspectInfoList.get(i).getDefaultAspect().AfterReturning(aClass,method,args,returnValue);
        }
        return returnValue;
    }

    private void invokeBeforeAdvice(Method method, Object[] args) throws Throwable {
        for(AspectInfo aspectInfo:aspectInfoList){
            aspectInfo.getDefaultAspect().Before(aClass,method,args);
        }

    }
}
