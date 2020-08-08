package org.myspringframework.aop.annotation;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    //对某一种标记的方法进行aop
    //如果value是@Controller,则对Controller下的所有方法进行aop
    Class<? extends Annotation> value();
}
