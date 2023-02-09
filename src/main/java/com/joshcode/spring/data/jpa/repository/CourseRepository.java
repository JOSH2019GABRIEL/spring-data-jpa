package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {




}
