package com.mazuryk.spring_boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestEnpoints {
    //In this example we will use another class (CourseConfiguration) to initialize our data
    @Value("${course.name}")
    private String newestName;
    @Value("${course.chapterCount}")
    private int newestChapterCount;
    @Value("${course.rating}")
    private int newestRating;
    @Value("${course.visitor}")
    private String newestVisitor;

    @Autowired
    private CourseConfiguration courseConfiguration;
    //Let's do another RequestMapping
    @RequestMapping("/getHierarchical")
    public HashMap<String, Object> getConfigAnnotateProperties(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", courseConfiguration.getName());
        map.put("chapterCount", courseConfiguration.getChapterCount());
        map.put("rating", courseConfiguration.getRating());
        map.put("visitor", courseConfiguration.getVisitor());
        return map;
    }



    //When we want to give a value from application.properties file
    //We need to create a new values and  use @Value annotation
    @Value("${default.course.name}")
    private String newName;

    @Value("${default.course.chapterCount}")
    private int newChapterCount;
    //And then we use a new get method( same one )
    @RequestMapping("/default")
    public Course getDefaultValues(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
                           @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
    ){
        return new Course(newName, newChapterCount);
    }

    //It's a get method of request
    @RequestMapping("/course")
    public Course getpoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
                           @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount
                           ){
        return new Course(name, chapterCount);
    }

    //It's a post method of request
    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course){
        return "Your course named " + course.getName() + " with " + course.getChapterCount() + " chapters successfully." ;
    }
}
