package com.courseplatform.CoursePlatform.repository;

import com.courseplatform.CoursePlatform.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
