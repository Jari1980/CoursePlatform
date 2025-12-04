package com.courseplatform.CoursePlatform.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InstructorDTO extends UserDTO{
    private String department;
    private String title;
}
