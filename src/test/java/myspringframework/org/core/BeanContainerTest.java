package myspringframework.org.core;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.myspringframework.core.BeanContainer;

public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();

    }

    @Test
    public void loadBeanTest(){
        beanContainer.loadBeans("com.klay");
        beanContainer.isLoaded();
    }
}
