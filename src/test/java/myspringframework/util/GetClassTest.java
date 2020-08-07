package myspringframework.util;

import org.junit.jupiter.api.Test;
import org.myspringframework.util.ClassUtil;

import java.util.Set;

public class GetClassTest {
    @Test
    public void getClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.klay.entity");
        System.out.println(classSet);
    }
}
