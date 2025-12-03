package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_badge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentBadge {
    @EmbeddedId
    private StudentBadgeId id;
    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("badgeId")
    private Badge badge;
    private LocalDate awardedAt;
    @PrePersist
    public void award(){
        this.awardedAt = LocalDate.now();
    }
}
