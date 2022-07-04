package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//this is responsible for database access

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByEmail(String email);
}
