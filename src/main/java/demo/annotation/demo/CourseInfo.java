package demo.annotation.demo;


import demo.annotation.CourseInfoAnnotation;
import demo.annotation.PersonInfoAnnotation;

@CourseInfoAnnotation(name = "计算机网络",tag = "计算机")
public class CourseInfo {

    @PersonInfoAnnotation(name = "Kay",language = {"c++","python"})
    public String author;


    @CourseInfoAnnotation(name = "操作系统",tag = "系统")
    public void getCourseInfo(){

    }

}
