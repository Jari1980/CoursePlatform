package com.courseplatform.CoursePlatform.dto;

import com.courseplatform.CoursePlatform.model.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;
    private UserType usertype;
}
