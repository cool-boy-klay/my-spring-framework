package demo.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AliInvocationHandler implements InvocationHandler {

    private Object targetObject;
    public AliInvocationHandler(Object object){
        this.targetObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Before();
        Object result = method.invoke(targetObject,args);
        After();
        return result;


    }

    private void Before(){
        System.out.println("支付前:验证支付安全环境");
    }
    private void After(){
        System.out.println("支付成功:扣除库存");
    }
}
