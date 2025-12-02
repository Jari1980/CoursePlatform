package com.courseplatform.CoursePlatform.entity;

import com.courseplatform.CoursePlatform.model.UserType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class User {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String email;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private UserType usertype;
    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDate.now();
    }
}
