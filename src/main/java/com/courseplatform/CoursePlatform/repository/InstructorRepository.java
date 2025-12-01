package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
