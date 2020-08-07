package myspringframework.org.inject;

import com.klay.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.myspringframework.core.BeanContainer;
import org.myspringframework.inject.DependencyInjector;

public class IOCTest {

    @DisplayName("依赖注入")
    @Test
    public void doIOC(){
        BeanContainer beanContainer =  BeanContainer.getInstance();
        beanContainer.loadBeans("com.klay");
        Assertions.assertTrue(beanContainer.isLoaded());
        MainPageController mainPageController=  (MainPageController)beanContainer.getBean(MainPageController.class);
        Assertions.assertNull(mainPageController.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIOC();
        Assertions.assertNotNull(mainPageController.getHeadLineShopCategoryCombineService());
    }
}
