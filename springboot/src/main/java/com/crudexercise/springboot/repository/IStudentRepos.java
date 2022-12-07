package com.crudexercise.springboot.repository;

import java.util.List;

import com.crudexercise.springboot.model.Student;

public interface IStudentRepos {
    public Student insertStudent(Student student);

    public List<Student> getAllStudent();

    public Student updateStudent(int id, Student student);

    public Student deleteStudent(int id);

    public Student getSelectedStudent(int id);
}
