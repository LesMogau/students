package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;        //reference to student service

    //this is used the student reference inside of the student controller
    @Autowired //the top student service should be automaggically wired to this instance of student service
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){

        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //for deleting
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
            studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam( required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }

}
