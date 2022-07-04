package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student lesedi = new Student(1L,
                    "lesedi",
                    "lesedi@gmail.com",
                    LocalDate.of(2000, Month.JUNE, 3)
            );
            Student katlego = new Student(3L,
                    "katlego",
                    "katlego@gmail.com",
                    LocalDate.of(2002, Month.JULY, 7)
            );
           Student alex = new Student(2L,
                    "alex",
                    "Alex@gmail.com",
                    LocalDate.of(2004, Month.JULY, 3)
            );

           repository.saveAll(List.of(lesedi,katlego,alex));
        };
    }
}
