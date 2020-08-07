package demo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//在类成员变量中作用
@Target(ElementType.FIELD)
//运行时生成 要想反射调用必须使用RetentionPolicy.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {

    public String name() ;

    public int age() default 19;

    public String gender() default "男";

    public String []language() ;
}
