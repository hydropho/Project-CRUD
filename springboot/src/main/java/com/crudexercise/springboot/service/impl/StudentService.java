package com.crudexercise.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudexercise.springboot.model.Student;
import com.crudexercise.springboot.repository.IStudentRepos;
import com.crudexercise.springboot.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepos studentRepos;

    @Override
    public Student insertStudent(Student student) {
        // TODO Auto-generated method stub
        return studentRepos.insertStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
        return studentRepos.getAllStudent();
    }

    @Override
    public Student updateStudent(int id, Student student) {
        // TODO Auto-generated method stub
        return studentRepos.updateStudent(id, student);
    }

    @Override
    public Student deleteStudent(int id) {
        // TODO Auto-generated method stub
        return studentRepos.deleteStudent(id);
    }

    @Override
    public Student getSelectedStudent(int id) {
        // TODO Auto-generated method stub
        return studentRepos.getSelectedStudent(id);
    }

}
