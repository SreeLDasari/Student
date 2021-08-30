package com.testannotation.studentservice.service;

import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Component;

import com.testannotation.studentservice.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
    	Student student1 = new Student("Y4CS78", "Sanv","ME","JNTU");
        Student student2 = new Student("Y4CS99", "Manv","EEE","NU");
        students.addAll(Arrays.asList(student1, student2));
    }
    public Optional<Student> findStudentByrollNo(String rollNo) {
        Student studentFound = null;
        for(Student student : students){
            if(student.getRollNo().equals(rollNo))
            	studentFound = student;
        }
            return Optional.ofNullable(studentFound);
    }

    public Student addStudent(Student student){
        long rollNo = (long) (Math.floor(Math.random() * (9*Math.pow(10, 9))) + Math.pow(10, 9));
        student.setRollNo(Long.toString(rollNo));
        students.add(student);
        return student;
    }
}
