package com.robeil.eregistrar.service;

import com.robeil.eregistrar.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    void addNewStudent(Student student);
    Page<Student> getAllStudents(int pageNo);
    void updateStudent(Student student);
    void deleteStudentById(Long studentId);
    Student findStudentById(Long studentId);

}
