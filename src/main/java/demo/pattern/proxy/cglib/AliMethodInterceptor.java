package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.Method;

public class AliMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Before();
        Object re = methodProxy.invokeSuper(o,objects);
        After();

        return re;
    }

    private void Before(){
        System.out.println("支付前:验证支付安全环境");
    }
    private void After(){
        System.out.println("支付成功:扣除库存");
    }
}
