package com.example.studentprofile.Service;

import com.example.studentprofile.Repository.StudentRepository;
import com.example.studentprofile.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }

    public Student searchStudent(String student_name) throws Exception {
        Student student = studentRepository.findByName(student_name)
                .orElseThrow(() -> new Exception("No student found"));
        return student;
    }

    public Student updateStudent(Student s, Long student_id) throws Exception {
        Student student = studentRepository.findById(student_id).
                orElseThrow(() ->  new Exception ("Student id was not found"));
        student.setAge(s.getAge());
        student.setGender(s.getGender());
        student.setName(s.getName());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long student_id) throws Exception {
        Student student = studentRepository.findById(student_id).
                orElseThrow(() ->  new Exception ("Student id was not found"));
        studentRepository.delete(student);
    }


}

