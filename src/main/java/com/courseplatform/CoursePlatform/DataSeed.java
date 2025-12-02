package com.courseplatform.CoursePlatform;

import com.courseplatform.CoursePlatform.entity.*;
import com.courseplatform.CoursePlatform.entity.Module;
import com.courseplatform.CoursePlatform.model.UserType;
import com.courseplatform.CoursePlatform.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;

import java.time.LocalDate;

import static javax.management.relation.Role.*;

@Component
public class DataSeed implements CommandLineRunner {

    private BadgeRepository badgeRepository;
    private CourseAssignmentRepository courseAssignmentRepository;
    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;
    private ModuleRepository moduleRepository;
    private StudentRepository studentRepository;
    private SubmissionRepository submissionRepository;
    private UserRepository userRepository;

    @Autowired
    public DataSeed(BadgeRepository badgeRepository, CourseAssignmentRepository courseAssignmentRepository,
                    CourseRepository courseRepository, InstructorRepository instructorRepository,
                    ModuleRepository moduleRepository, StudentRepository studentRepository,
                    SubmissionRepository submissionRepository, UserRepository userRepository){
        this.badgeRepository = badgeRepository;
        this.courseAssignmentRepository = courseAssignmentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.moduleRepository = moduleRepository;
        this.studentRepository = studentRepository;
        this.submissionRepository = submissionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.count() > 0){
            System.out.println("Not seeding since there are posts in userrepo already.");
            return;
        }

        System.out.println("Seeding data...");


        // Users

        Instructor instructor = userRepository.save(
                Instructor.builder()
                        .name("Jedi")
                        .email("jedi@test.com")
                        .title("SnusMan")
                        .department("Coruscant")
                        .usertype(UserType.INSTRUCTOR)
                        .build()
        );
        Student student1 = userRepository.save(
                Student.builder()
                        .name("Padawan1")
                        .email("Padawan1@test.com")
                        .major("Broccoli")
                        .enrollmentYear(2022)
                        .usertype(UserType.STUDENT)
                        .build()
        );
        Student student2 = userRepository.save(
                Student.builder()
                        .name("Padawan2")
                        .email("Padawan2@test.com")
                        .major("Snus")
                        .enrollmentYear(2025)
                        .usertype(UserType.STUDENT)
                        .build()
        );

        // Course

        Course course = courseRepository.save(
                Course.builder()
                        .title("Java in underpants")
                        .instructor(instructor)
                        .build()
        );


        // Enrollments @ManyToMany

        course.getEnrolledStudent().add(student1);
        course.getEnrolledStudent().add(student2);
        courseRepository.save(course);

        // Module and Lessons

        Module module1 = moduleRepository.save(
                Module.builder()
                        .title("Java in heat")
                        .course(course)
                        .build()
        );
        Module module2 = moduleRepository.save(
                Module.builder()
                        .title("Java in cold")
                        .course(course)
                        .build()
        );

        // Course assignments
        CourseAssignment assignment1 = courseAssignmentRepository.save(
                CourseAssignment.builder()
                        .module(module1)
                        .title("First Assignment")
                        .dueDate(LocalDate.now().plusMonths(1))
                        .build()
        );
        CourseAssignment assignment2 = courseAssignmentRepository.save(
                CourseAssignment.builder()
                        .module(module1)
                        .title("Second Assignment")
                        .dueDate(LocalDate.now().plusMonths(2))
                        .build()
        );

    }
}
