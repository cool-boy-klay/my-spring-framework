package demo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target(ElementType.TYPE) 作用接口、类、枚举、注解
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfoAnnotation {

    public String name();

    public String tag();

    public int index() default 100;

}
