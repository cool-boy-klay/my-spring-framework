package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

public class ToCPaymentImpl implements ToCPayment {

    @Override
    public void pay() {
        System.out.println("ToC支付中————");
    }
}
