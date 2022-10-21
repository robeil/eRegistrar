package com.robeil.eregistrar.service.impl;

import com.robeil.eregistrar.model.Student;
import com.robeil.eregistrar.repository.StudentRepository;
import com.robeil.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo,4, Sort.Direction.ASC,"firstName"));

    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentRepository.findStudentByStudentId(studentId);
    }
}
