package org.myspringframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassUtil {
    public static String FILE_PROTOCOL = "file";

    public static Set<Class<?>> extractPackageClass(String packageName){
        //获取类加载器
        ClassLoader classLoader = getClassLoader();
        URL url=  classLoader.getResource(packageName.replace(".","/"));
        if(url==null){
            log.error("无法通过资源路径找到对应的资源");
            return null;
        }
        Set<Class<?>> classSet = null;
        if(url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getFile());
            extractClassFile(classSet,packageDirectory,packageName);
        }
        return classSet;
    }

    private static void extractClassFile(Set<Class<?>> classSet, File fileSource, String packageName) {
        if(!fileSource.isDirectory()){
            return;
        }
        //获取文件夹下的所有文件和文件夹
        else{
            File []files = fileSource.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.isDirectory()){
                        return true;
                    }else {
                        String absolutePath = pathname.getAbsolutePath();
                        if(absolutePath.endsWith(".class")){
                            addToClassSet(absolutePath);
                        }

                    }
                    return false;
                }

                private void addToClassSet(String absolutePath) {
                    absolutePath = absolutePath.replace(File.separator,".");
                    String className = absolutePath.substring(absolutePath.indexOf(packageName));
                    className =  className.substring(0,className.lastIndexOf("."));

                    try {
                        Class c = Class.forName(className);
                        classSet.add(c);
                    } catch (ClassNotFoundException e) {
                        log.error("无法加载对应的类");

                    }

                }
            });
            if(files!=null){
                for(File file:files){
                    extractClassFile(classSet, file, packageName);
                }
            }

        }
    }

    public static  ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }


    public static <T> T newInstance(Class<T> clazz,boolean accessible){


        try {
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T)constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("new instance error:"+clazz);
            throw new RuntimeException();
        }

    }
}
