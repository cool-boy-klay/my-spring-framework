package demo.reflect;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 获取Class的三种方法
 */
public class ReflectTarget {
    private String name;
    private int age;

    ReflectTarget(){
        name = "klay";
        age = 21;
    }

    public ReflectTarget(String name){
        this.name = name;
        age = 22;
    }

    private ReflectTarget(String name,int age){
        this.name=  name;
        this.age=  age;
    }

    public void say(){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
    }





    public static void main(String[] args) throws ClassNotFoundException {
        //1.
        String s1 = new String("hello");
        Class c1 = s1.getClass();
        System.out.println("1:"+c1.getName());

        //2.
        Class c2 = String.class;
        System.out.println("2:"+c2.getName());
        System.out.println(c1==c2);

        //3.
        Class c3 = Class.forName("java.lang.String");
        System.out.println("3:"+c3.getName());
        System.out.println(c3==c2);


    }
}
