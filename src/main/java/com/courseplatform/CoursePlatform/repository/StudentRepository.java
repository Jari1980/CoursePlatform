package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
