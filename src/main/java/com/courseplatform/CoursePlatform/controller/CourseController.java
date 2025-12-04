package com.courseplatform.CoursePlatform.controller;

import com.courseplatform.CoursePlatform.dto.InstructorDTO;
import com.courseplatform.CoursePlatform.dto.StudentDTO;
import com.courseplatform.CoursePlatform.dto.UserDTO;
import com.courseplatform.CoursePlatform.entity.Student;
import com.courseplatform.CoursePlatform.entity.User;
import com.courseplatform.CoursePlatform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final UserService userService;

    public CourseController(UserService userService){
        this.userService = userService;
    }

    //User requests
    @GetMapping("/getallusers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/getallstudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(userService.getAllStudents());
    }
    @GetMapping("/getallinstructors")
    public ResponseEntity<List<InstructorDTO>> getAllInstructors(){
        return ResponseEntity.ok(userService.getAllInstructors());
    }
}
