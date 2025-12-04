package com.courseplatform.CoursePlatform.service;

import com.courseplatform.CoursePlatform.dto.InstructorDTO;
import com.courseplatform.CoursePlatform.dto.StudentDTO;
import com.courseplatform.CoursePlatform.dto.UserDTO;
import com.courseplatform.CoursePlatform.entity.Instructor;
import com.courseplatform.CoursePlatform.entity.Student;
import com.courseplatform.CoursePlatform.entity.User;
import com.courseplatform.CoursePlatform.mapper.UserMapper;
import com.courseplatform.CoursePlatform.model.UserType;
import com.courseplatform.CoursePlatform.repository.InstructorRepository;
import com.courseplatform.CoursePlatform.repository.StudentRepository;
import com.courseplatform.CoursePlatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, StudentRepository studentRepository,
                       InstructorRepository instructorRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.userMapper = userMapper;
    }


    public List<UserDTO> getAllUsers(){
        //return userRepository.findAll(); (with return type List<User>, would return whole db with everything connected, so I use DTO)
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(userMapper::toStudentDTO)
                .toList();
    }

    public List<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(userMapper::toInstructorDTO)
                .toList();
    }

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = userMapper.toStudentEntity(dto);
        student.setUsertype(UserType.STUDENT);
        Student saved = studentRepository.save(student);

        return userMapper.toStudentDTO(saved);
    }

    public InstructorDTO createInstructor(InstructorDTO dto) {
        Instructor instructor = userMapper.toInstructorEntity(dto);
        instructor.setUsertype(UserType.INSTRUCTOR);
        Instructor saved = instructorRepository.save(instructor);

        return userMapper.toInstructorDTO(saved);
    }
}
