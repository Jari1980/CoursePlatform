package com.courseplatform.CoursePlatform.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentBadgeId implements Serializable {
    private Long studentId;
    private Long badgeId;
}
