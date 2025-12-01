package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
