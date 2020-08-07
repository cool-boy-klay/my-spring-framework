package myspringframework.org.core;


import com.klay.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import com.klay.service.solo.HeadLineService;
import com.klay.service.solo.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;
import org.myspringframework.core.BeanContainer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();

    }

    @Order(1)
    @Test
    public void loadBeanTest(){
        beanContainer.loadBeans("com.klay");
        Assertions.assertTrue(beanContainer.isLoaded());
    }

    @Order(2)
    @Test
    public void getBeanTest(){
        HeadLineShopCategoryCombineServiceImpl headLineShopCategoryCombineService = (HeadLineShopCategoryCombineServiceImpl) beanContainer.getBean(HeadLineShopCategoryCombineServiceImpl.class);

    }

    @DisplayName("根据接口获取实现类")
    @Order(3)
    @Test
    public void getBeanTest2(){
        Assertions.assertTrue(beanContainer.getClassByInterface(HeadLineService.class).contains(HeadLineServiceImpl.class));

    }
}
