package com.crudexercise.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudexercise.springboot.model.Student;
import com.crudexercise.springboot.service.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getSelectedStudent/{id}")
    public Student getSelectedStudent(@PathVariable int id) {
        return studentService.getSelectedStudent(id);
    }
}
