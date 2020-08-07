package org.myspringframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.myspringframework.core.BeanContainer;
import org.myspringframework.inject.annotation.Autowired;
import org.myspringframework.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class DependencyInjector {
    private BeanContainer beanContainer;

    public DependencyInjector(){
        beanContainer = BeanContainer.getInstance();
    }


    /**
     * 执行IOC依赖注入
     */
    public void doIOC(){
        if(beanContainer.getAllClasses()==null||beanContainer.getAllClasses().size()==0){
            log.warn("doIOC:容器中没有任何类实例");
        }
        //1.遍历Bean容器所有的Class对象
        for(Class clazz:beanContainer.getAllClasses()){
            //2.遍历Class对象的所有成员变量
            Field []fields=  clazz.getDeclaredFields();
            for(Field field:fields){
                //3.找出被Autowired标记的成员变量
                if(field.isAnnotationPresent(Autowired.class)){
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    //4.找出成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量类型在容器里的实例
                    Object fieldValue = getFieldInstance(fieldClass,autowired.value());
                    if(fieldValue==null){
                        log.error("doIOC:无法在容器中找到对应的成员变量实例");
                        throw new RuntimeException();
                    }
                    //6.通过反射将这些在容器中的成员变量实例注入到所在类的实例
                    Object targetBean = beanContainer.getBean(clazz);
                    ClassUtil.setField(field,targetBean,fieldValue,true);
                }
            }


        }


    }

    /**
     * 在容器中获取成员变量对应的bean实例
     *
     * 比如
     * @Autowired
     * private HeadLineService headLineService;
     * 就会从bean容器中找到对应的headLineService对应bean实例
     * @param fieldClass
     * @param autowiredValue
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass,String autowiredValue) {

        Object fieldValue = beanContainer.getBean(fieldClass);
        if(fieldValue!=null){
            return fieldValue;
        }else {
            //找到private HeadLineService headLineService 对应的实现类
            Class<?> implementedClass = getImplementClass(fieldClass,autowiredValue);
            if(implementedClass!=null){
                return beanContainer.getBean(implementedClass);
            }
        }
        return null;
    }

    private Class<?> getImplementClass(Class<?> fieldClass,String autowiredValue) {
        Set<Class<?>> classSet=  beanContainer.getClassByInterface(fieldClass);
        if(classSet!=null&&classSet.size()!=0){
            //未指定对应实现类
            if(autowiredValue==null||autowiredValue.length()==0){
                if(classSet.size()==1){
                    return classSet.iterator().next();
                }
                else {
                    throw new RuntimeException("拥有两个及以上的实现类而且未指定对应的实现类");
                }


            }
            //指定对应实现类
            else{
                for(Class<?> clazz:classSet){
                    if(autowiredValue.equals(clazz.getSimpleName())){
                        return clazz;
                    }

                }
            }

        }
        return null;
    }

}
