package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service    //annotation for clearifying that this is a service class
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
        throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
        System.out.println(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);

        if (!exist){
            throw new IllegalStateException("Student with ID: "+studentId+" does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("Student with ID: "+studentId+" does not exist"));

    }
}
