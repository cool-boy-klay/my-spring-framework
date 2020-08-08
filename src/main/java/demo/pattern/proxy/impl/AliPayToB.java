package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

public class AliPayToB {
    private ToBPayment toBPayment;
     public AliPayToB(ToBPayment toBPayment){
         this.toBPayment = toBPayment;
     }

     public void pay(){
         Before();
         toBPayment.pay();
         After();
     }

     private void Before(){
         System.out.println("支付前:验证支付安全环境");
     }
    private void After(){
        System.out.println("支付成功:扣除库存");
    }
}
