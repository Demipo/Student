package com.example.studentprofile.Controller;

import com.example.studentprofile.Service.StudentService;
import com.example.studentprofile.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student s) {
        Student student1 = studentService.createStudent(s);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{student_name}", method = RequestMethod.GET)
    public ResponseEntity<Student> searchStudent(@PathVariable String student_name) throws Exception {
        Student student = studentService.searchStudent(student_name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(path = "/{student_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student s, @PathVariable Long student_id) throws Exception {
        Student student = studentService.updateStudent(s, student_id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(path = "/{student_id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long student_id) throws Exception {
        studentService.deleteStudent(student_id);
    }


}
