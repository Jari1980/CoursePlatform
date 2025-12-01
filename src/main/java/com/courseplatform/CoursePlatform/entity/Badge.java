package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "badge")
@Getter
@Setter
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String description;
    @OneToMany(mappedBy = "badge")
    private List<StudentBadge> students;
}
