package org.myspringframework.core;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myspringframework.core.annotation.Component;
import org.myspringframework.core.annotation.Controller;
import org.myspringframework.core.annotation.Repository;
import org.myspringframework.core.annotation.Service;
import org.myspringframework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /*
        存放所有被配置标记的目标对象Map
     */

    private final Map<Class<?>,Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 存放注解Class文件
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);


    private boolean loaded = false;

    public boolean isLoaded(){
        return loaded;
    }

    /**
     * 枚举单例
     * @return
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
        HOLDER;
        private BeanContainer instance;
        ContainerHolder(){
            instance=  new BeanContainer();
        }


    }

    /**
     * 根据包名加载Bean实例到beanMap中
     * loadBeans只能加载一次
     * @param packageName
     */

    public synchronized void loadBeans(String packageName){
        if(isLoaded()){
            log.warn("BeanContainer不能重复加载");
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);

        if(classSet==null||classSet.size()==0){
            log.warn("从package中未能加载出Beans");
            return;
        }
        for(Class<?> clazz:classSet){
            for(Class<? extends Annotation> annotation:BEAN_ANNOTATION){
                if(clazz.isAnnotationPresent(annotation)){
                    beanMap.put(clazz,ClassUtil.newInstance(clazz,true));
                }
            }
        }
        loaded=true;
    }

    /**
     * 在beanMap中添加bean实例
     * @param clazz
     * @param bean
     * @return
     */
    public Object addBean(Class<?> clazz,Object bean){
        return beanMap.put(clazz, bean);
    }

    /**
     * 根据class删除IOC管理容器中的bean
     * @param clazz
     * @return
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }
}
