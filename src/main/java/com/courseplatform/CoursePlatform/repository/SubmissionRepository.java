package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
