package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "submission")
@Getter
@Setter
@Builder
public class Submission {
    @EmbeddedId
    private SubmissionId id;
    private LocalDateTime submittedAt;
    private Double grade;
    private String feedback;
    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("assignmentId")
    private CourseAssignment courseAssignment;
    @PrePersist
    public void onSubmit(){
        this.submittedAt = LocalDateTime.now();
    }
}
