package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
   private CourseRepository courseRepository;

@Test
public void printAllCourse(){

    List < Course> courses = courseRepository.findAll();

    System.out.println("List of courses in refences "+  courses);
}


//@Test
//public void deleteStudentById(){
//
//    Long CourseId = 1L;
// courseRepository.deleteById(CourseId);
//    System.out.println("Deleted Course Id ");
//}
}