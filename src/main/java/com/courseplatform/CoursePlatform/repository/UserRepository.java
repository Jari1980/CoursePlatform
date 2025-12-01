package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
