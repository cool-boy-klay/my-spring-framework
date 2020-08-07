package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c1=  Class.forName("demo.reflect.ReflectTarget");
        Constructor []constructors = c1.getConstructors();
        System.out.println("**************getConstructors**************");
        for (Constructor c:constructors
             ) {
            System.out.println(c);
        }

        Constructor []constructors2 = c1.getDeclaredConstructors();
        System.out.println("**************getConstructors**************");
        for (Constructor c:constructors2
        ) {
            System.out.println(c);
        }

        System.out.println("**************c1.getDeclaredConstructor(String.class)**************");
        Constructor constructor = c1.getDeclaredConstructor(String.class);
        System.out.println(constructor);

        System.out.println("**************c1.getDeclaredConstructor(String.class)**************");
        Constructor constructor2 = c1.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor2);

        //private方法需要设置
        constructor2.setAccessible(true);
        ReflectTarget reflectTarget= (ReflectTarget) constructor2.newInstance("jimmy",2);
        reflectTarget.say();
    }
}
