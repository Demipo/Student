package com.example.studentprofile.Repository;

import com.example.studentprofile.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);
}
