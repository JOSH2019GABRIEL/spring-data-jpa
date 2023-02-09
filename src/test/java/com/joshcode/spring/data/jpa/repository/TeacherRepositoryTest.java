package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Course;
import com.joshcode.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA = Course.builder()
                .title("DataBase Analyst")
                .credit(6)
                .build();
        Course courseJava = Course.builder()
                .title("Java Programming")
                .credit(5)
                .build();
        Course courseOOP = Course.builder()
                .title("Object Oriented Programming")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Johnson")
                .lastName("Peculiar")
                .courses(List.of(courseDBA,courseJava,courseOOP))
                .build();

teacherRepository.save(teacher);

        System.out.println("List of Teacher Attached with Course OneToMany " +teacher);

    }

}