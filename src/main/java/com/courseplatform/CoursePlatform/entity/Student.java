package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends User{
    private String major;
    private int enrollmentYear;
    @OneToMany(mappedBy = "student")
    private List<Submission> submissions;
    @OneToMany(mappedBy = "student")
    private List<StudentBadge> badges;

}
