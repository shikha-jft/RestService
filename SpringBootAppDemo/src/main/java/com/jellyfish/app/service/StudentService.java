package com.jellyfish.app.service;

import com.jellyfish.app.model.Course;
import com.jellyfish.app.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService{
    public List<Student> findStudentById(String id);
    List<Course> findCourses(String studentId);
    public Student findAllStudent(String studentId);
    public Course findAllCourseDetails(String studentId,String courseId);
    public Course addCourse(String studentId,Course course);
}
