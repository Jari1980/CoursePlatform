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
public class SubmissionId implements Serializable {
    private Long submissionId;
    private Long studentId;
    private Long assignmentId;
}
