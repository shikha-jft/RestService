package com.jellyfish.app.controller;
import com.jellyfish.app.model.Course;
import com.jellyfish.app.model.Student;
import com.jellyfish.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
     @Autowired
    private StudentService studentService;

  /* @PostMapping("/students/{studentId}/courses")
    public List<Student> findStudentById(@PathVariable("String sid") String sid){
        return studentService.findStudentById(sid);
    }*/
   @GetMapping("/students{studentId}/courses")
    public List<Course> retrieveCourseStudent(@PathVariable("studentId") String studentId){
        return studentService.findCourses(studentId);
    }
    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Void> registerStudentForCourse(
            @PathVariable String studentId, @RequestBody Course newCourse) {

        Course course = studentService.addCourse(studentId, newCourse);

        if (course == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/students{studentId}/courses/{courseId}")
    public Student findAllStudent(@PathVariable String sid,@PathVariable String courseId){
   return studentService.findAllStudent(sid);
    }
    @GetMapping("/students{studentId}/courses/{courseId}")
    public Course findAllCourseDetails(@PathVariable String studentId,@PathVariable String courseId){
   return studentService.findAllCourseDetails(studentId,courseId);
    }

    public Course addCourse(String studentId,Course course){
    return studentService.addCourse(studentId,new Course());
    }
}