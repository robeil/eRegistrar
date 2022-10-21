package com.robeil.eregistrar.repository;

import com.robeil.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByStudentId(Long StudentId);
    //List<Student> findAllByFirstNameContainingOrStudentNumber(String searchString);
}
