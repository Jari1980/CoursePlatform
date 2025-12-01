package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules;
}
