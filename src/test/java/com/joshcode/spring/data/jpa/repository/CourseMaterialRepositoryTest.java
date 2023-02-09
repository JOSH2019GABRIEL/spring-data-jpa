package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Course;
import com.joshcode.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Data Science Analyst")
                .credit(8)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.joshweb.org")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }
    @Test
    public void printAllCoursesMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("List of all courseMaterials" + courseMaterials);

    }

}