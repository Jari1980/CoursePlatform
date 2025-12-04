package com.courseplatform.CoursePlatform.service;

import com.courseplatform.CoursePlatform.dto.InstructorDTO;
import com.courseplatform.CoursePlatform.dto.StudentDTO;
import com.courseplatform.CoursePlatform.dto.UserDTO;
import com.courseplatform.CoursePlatform.entity.Course;
import com.courseplatform.CoursePlatform.entity.Instructor;
import com.courseplatform.CoursePlatform.entity.Student;
import com.courseplatform.CoursePlatform.entity.User;
import com.courseplatform.CoursePlatform.mapper.UserMapper;
import com.courseplatform.CoursePlatform.model.UserType;
import com.courseplatform.CoursePlatform.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final UserMapper userMapper;
    private final SubmissionRepository submissionRepository;
    private final StudentBadgeRepository studentBadgeRepository;
    private final CourseRepository courseRepository;

    public UserService(UserRepository userRepository, StudentRepository studentRepository,
                       InstructorRepository instructorRepository, UserMapper userMapper,
                       SubmissionRepository submissionRepository, StudentBadgeRepository studentBadgeRepository,
                       CourseRepository courseRepository){
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.userMapper = userMapper;
        this.submissionRepository = submissionRepository;
        this.studentBadgeRepository = studentBadgeRepository;
        this.courseRepository = courseRepository;
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

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        userMapper.updateStudentEntity(student, dto);

        Student updated = studentRepository.save(student);
        return userMapper.toStudentDTO(updated);
    }

    public InstructorDTO updateInstructor(Long id, InstructorDTO dto) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        userMapper.updateInstructorEntity(instructor, dto);

        Instructor updated = instructorRepository.save(instructor);
        return userMapper.toInstructorDTO(updated);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 1. Delete submissions (child with @MapsId)
        if (student.getSubmissions() != null && !student.getSubmissions().isEmpty()) {
            submissionRepository.deleteAll(student.getSubmissions());
        }

        // 2. Delete student badges (child with @MapsId)
        if (student.getBadges() != null && !student.getBadges().isEmpty()) {
            studentBadgeRepository.deleteAll(student.getBadges());
        }

        // 3. Remove from course enrollments (Many-to-Many)
        List<Course> allCourses = courseRepository.findAll();
        for (Course course : allCourses) {
            if (course.getEnrolledStudent().contains(student)) {
                course.getEnrolledStudent().remove(student);
            }
        }
        studentRepository.deleteById(id);
    }

    public void deleteInstructor(Long id) {
        //Detaching courses before delete
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        if (instructor.getCourses() != null) {
            instructor.getCourses().forEach(course -> course.setInstructor(null));
        }
        instructorRepository.deleteById(id);
    }
}
