package com.crudexercise.springboot.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crudexercise.springboot.model.Student;
import com.crudexercise.springboot.repository.IStudentRepos;

@Repository
public class StudentRepos implements IStudentRepos {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Student insertStudent(Student student) {
        // TODO Auto-generated method stub
        String query = "INSERT INTO tb_student(name, age, gender, email, soft_skill, hard_skill, self_description, interest) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                new Object[] { student.getName(), student.getAge(), student.getGender(), student.getEmail(),
                        student.getSoft_skill(), student.getHard_skill(), student.getSelf_description(),
                        student.getInterest() });

        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_student";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student updateStudent(int id, Student student) {
        // TODO Auto-generated method stub
        String query = "UPDATE tb_student SET name = ?, age = ?, gender = ?, email = ?, soft_skill = ?, hard_skill = ?, self_description = ?, interest = ? WHERE id = ?";
        jdbcTemplate.update(query,
                new Object[] { student.getName(), student.getAge(), student.getGender(),
                        student.getEmail(),
                        student.getSoft_skill(), student.getHard_skill(), student.getSelf_description(),
                        student.getInterest(),
                        id });

        return student;
    }

    @Override
    public Student deleteStudent(int id) {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_student WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);

        query = "DELETE FROM tb_student WHERE id = ?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public Student getSelectedStudent(int id) {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_student WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);

        return result;
    }

}
