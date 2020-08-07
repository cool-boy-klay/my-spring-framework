package demo.annotation.demo;

import demo.annotation.CourseInfoAnnotation;
import demo.annotation.PersonInfoAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ParseAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c1 = Class.forName("demo.annotation.demo.CourseInfo");

        Annotation [] annotations = c1.getAnnotations();

        for(Annotation annotation:annotations){
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation)annotation;
            System.out.println(courseInfoAnnotation.name());
            System.out.println(courseInfoAnnotation.index());
            System.out.println(courseInfoAnnotation.tag());
        }

        System.out.println("*************Fields***************");
        Field []fields = c1.getFields();
        for(Field field:fields){
            boolean hasAnnotation = field.isAnnotationPresent(PersonInfoAnnotation.class);
            if(hasAnnotation){
                PersonInfoAnnotation personInfoAnnotation = field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println(personInfoAnnotation.name());
                System.out.println(personInfoAnnotation.age());
                System.out.println(personInfoAnnotation.gender());
                for(String s:personInfoAnnotation.language()){
                    System.out.println(s);
                }

            }

        }
        System.out.println("*************Method***************");
        Method []methods = c1.getMethods();
        for(Method method:methods){
            boolean hasAnnotation = method.isAnnotationPresent(CourseInfoAnnotation.class);
            if(hasAnnotation){
                CourseInfoAnnotation courseInfoAnnotation = method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println(courseInfoAnnotation.name());
                System.out.println(courseInfoAnnotation.index());
                System.out.println(courseInfoAnnotation.tag());
            }

        }

    }
}
