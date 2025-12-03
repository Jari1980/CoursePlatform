package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courseAssignment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
