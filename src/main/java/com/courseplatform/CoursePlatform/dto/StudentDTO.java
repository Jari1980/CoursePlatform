package com.courseplatform.CoursePlatform.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class StudentDTO extends UserDTO{
    private String major;
    private int enrollmentYear;
}
