package com.courseplatform.CoursePlatform.controller;

import com.courseplatform.CoursePlatform.dto.InstructorDTO;
import com.courseplatform.CoursePlatform.dto.StudentDTO;
import com.courseplatform.CoursePlatform.dto.UserDTO;
import com.courseplatform.CoursePlatform.entity.Student;
import com.courseplatform.CoursePlatform.entity.User;
import com.courseplatform.CoursePlatform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/createstudent")
    public StudentDTO create(@RequestBody StudentDTO dto) {
        return userService.createStudent(dto);
    }
    @PostMapping("/createinstructor")
    public InstructorDTO create(@RequestBody InstructorDTO dto) {
        return userService.createInstructor(dto);
    }
}
