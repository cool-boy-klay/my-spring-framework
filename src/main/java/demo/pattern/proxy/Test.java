package demo.pattern.proxy;

import demo.pattern.proxy.cglib.AliMethodInterceptor;
import demo.pattern.proxy.cglib.CglibUtil;
import demo.pattern.proxy.cglib.CommonPayment;
import demo.pattern.proxy.dynamicProxy.AliInvocationHandler;
import demo.pattern.proxy.dynamicProxy.JdkDynamicProxyUtil;
import demo.pattern.proxy.impl.ToBPaymentImpl;

public class Test {
    public static void main(String[] args) {
//        ToBPayment toBPayment = new ToBPaymentImpl();
//        AliPayToB aliPayToB = new AliPayToB(toBPayment);
//        aliPayToB.pay();

        ToBPayment toBPayment = new ToBPaymentImpl();
        AliInvocationHandler aliInvocationHandler = new AliInvocationHandler(toBPayment);
        ToBPayment toBPaymentProxy =  JdkDynamicProxyUtil.newProxyInstance(toBPayment,aliInvocationHandler);
        toBPaymentProxy.pay();

        CommonPayment commonPayment = new CommonPayment();
        AliMethodInterceptor aliMethodInterceptor = new AliMethodInterceptor();
        CommonPayment commonPaymentProxy= CglibUtil.createProxy(commonPayment,aliMethodInterceptor);
        commonPaymentProxy.pay();
    }
}
