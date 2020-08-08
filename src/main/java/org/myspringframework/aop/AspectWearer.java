package org.myspringframework.aop;

import org.myspringframework.aop.annotation.Aspect;
import org.myspringframework.aop.annotation.Order;
import org.myspringframework.aop.aspect.AspectInfo;
import org.myspringframework.aop.aspect.DefaultAspect;
import org.myspringframework.core.BeanContainer;

import java.lang.annotation.Annotation;
import java.util.*;

public class AspectWearer {
    private BeanContainer beanContainer;
    public AspectWearer(){
        this.beanContainer = BeanContainer.getInstance();
    }

    public void doAOP(){
        //1.获取所有切面类
        Set<Class<?>> aspectSet = beanContainer.getClassByAnnotation(Aspect.class);
        //2.将切面类按照不同的织入目标划分
        Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap = new HashMap<>();
        if(aspectSet==null||aspectSet.size()==0){
            return;
        }
        for(Class<? > aspectClass:aspectSet){
            if(verifyAspect(aspectClass)){
                categorizeAspect(categorizedMap,aspectClass);
            }
            else{
                throw new RuntimeException("一定要给Aspect类添加@Aspect和@Order注解并且继承自DefaultAspect类\n" +
                        "同时Aspect的属性值不能是它自身");
            }
        }
        //3.按照不同的织入目标按序织入Aspect的逻辑
        if(categorizedMap.size()==0)
            return;
        for (Class<? extends Annotation> category:categorizedMap.keySet()){
            weaveByCategory(category,categorizedMap.get(category));
        }
    }

    private void weaveByCategory(Class<? extends Annotation> category, List<AspectInfo> aspectInfos) {

        //1.获取被代理类集合 ———— 获取@Aspect(value="A")里面的A对应的被代理类
        Set<Class<?>> classSet = beanContainer.getClassByAnnotation(category);
        if(classSet==null||classSet.size()==0)
            return;
        //2.遍历被代理类，分别为每个被代理类生成动态代理实例
        for(Class<?> targetClass:classSet){
            AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass,aspectInfos);
            Object proxy = ProxyCreator.createProxy(targetClass,aspectListExecutor);
            //3.将动态代理后的bean实例替换掉原来的实例
            beanContainer.addBean(targetClass,proxy);
        }



    }


    private void categorizeAspect(Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap, Class<?> aspectClass) {
        Order orderTag= aspectClass.getAnnotation(Order.class);
        Aspect aspectTag = aspectClass.getAnnotation(Aspect.class);
        DefaultAspect aspect = (DefaultAspect) beanContainer.getBean(aspectClass);
        AspectInfo aspectInfo = new AspectInfo(orderTag.value(),aspect);
        //@Aspect(value="A")对应的A还没有被其他DefaultAspect类织入
        if(!categorizedMap.containsKey(aspectTag.value())){
            List<AspectInfo> aspectInfoList = new ArrayList<>();
            aspectInfoList.add(aspectInfo);
            categorizedMap.put(aspectTag.value(),aspectInfoList);
        }
        //@Aspect(value="A")对应的A已经被其他DefaultAspect类织入,需要在尾部添加
        else{
            List<AspectInfo> aspectInfoList = categorizedMap.get(aspectTag.value());
            aspectInfoList.add(aspectInfo);
        }
    }


    /**
     * 一定要给Aspect类添加@Aspect和@Order注解并且继承自DefaultAspect类，否则都不合法报错
     * 同时Aspect的属性值不能是它自身,如下是不合法的
     *
     * @Aspect(value="A")
     * @Order(value=1)
     * public class A extends DefaultAspect{
     *     .....
     * }
     *
     * @param aspectClass
     * @return
     */
    private boolean verifyAspect(Class<?> aspectClass) {
        return aspectClass.isAnnotationPresent(Aspect.class)&&
                aspectClass.isAnnotationPresent(Order.class)&&
                DefaultAspect.class.isAssignableFrom(aspectClass)&&
                aspectClass.getAnnotation(Aspect.class).value()!=aspectClass;
    }
}
