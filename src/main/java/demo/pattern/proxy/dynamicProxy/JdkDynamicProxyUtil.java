package demo.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyUtil {

    public static  <T> T newProxyInstance(T target, InvocationHandler invocationHandler){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?> []interfaces = target.getClass().getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

    }
}
