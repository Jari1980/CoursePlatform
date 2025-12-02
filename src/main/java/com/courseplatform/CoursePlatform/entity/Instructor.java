package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Instructor extends User{
    private String department;
    private String title;
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}
