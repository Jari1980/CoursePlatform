package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courseAssignment")
@Getter
@Setter
@Builder
public class CourseAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
    @OneToMany(mappedBy = "courseAssignment")
    private List<Submission> submissions;
}
