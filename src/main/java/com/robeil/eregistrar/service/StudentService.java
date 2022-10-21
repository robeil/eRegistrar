package com.robeil.eregistrar.service;

import com.robeil.eregistrar.model.Student;

import java.util.List;

public interface StudentService {

    void addNewStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudentById(Long studentId);
    Student findStudentById(Long studentId);

}
