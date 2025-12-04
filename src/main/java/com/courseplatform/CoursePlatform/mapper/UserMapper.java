package com.courseplatform.CoursePlatform.mapper;

import com.courseplatform.CoursePlatform.dto.InstructorDTO;
import com.courseplatform.CoursePlatform.dto.StudentDTO;
import com.courseplatform.CoursePlatform.dto.UserDTO;
import com.courseplatform.CoursePlatform.entity.Instructor;
import com.courseplatform.CoursePlatform.entity.Student;
import com.courseplatform.CoursePlatform.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user instanceof Student student) {
            return toStudentDTO(student);
        } else if (user instanceof Instructor instructor) {
            return toInstructorDTO(instructor);
        } else {
            return toUserDTO(user);
        }
    }

    private UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .usertype(user.getUsertype())
                .build();
    }

    public StudentDTO toStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCreatedAt(student.getCreatedAt());
        dto.setUsertype(student.getUsertype());
        dto.setMajor(student.getMajor());
        dto.setEnrollmentYear(student.getEnrollmentYear());
        return dto;
    }

    public InstructorDTO toInstructorDTO(Instructor instructor) {
        InstructorDTO dto = new InstructorDTO();
        dto.setId(instructor.getId());
        dto.setName(instructor.getName());
        dto.setEmail(instructor.getEmail());
        dto.setCreatedAt(instructor.getCreatedAt());
        dto.setUsertype(instructor.getUsertype());
        dto.setDepartment(instructor.getDepartment());
        dto.setTitle(instructor.getTitle());
        return dto;
    }
}
