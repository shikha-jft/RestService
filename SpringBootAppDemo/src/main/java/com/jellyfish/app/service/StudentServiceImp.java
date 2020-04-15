package com.jellyfish.app.service;

import com.jellyfish.app.model.Course;
import com.jellyfish.app.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    private static List<Student> studentList=new ArrayList<>();

    static {
        Course course1 = new Course("course1", "Spring", "10steps");
        Course course2 = new Course("course2", "Java", "8steps");
        Course course3 = new Course("course3", "Html", "6steps");
        Course course4 = new Course("course4", "Css", "9steps");
        Student shikha = new Student("s1", "shikha", "10step", Arrays.asList(course1, course2, course3, course4));
        Student shailja = new Student("s2", "shailja", "12step", Arrays.asList(course1, course2, course3, course4));
        Student megha = new Student("s3", "megha", "11step", Arrays.asList(course1, course2, course3, course4));
        Student pinku = new Student("s4", "pinku", "8step", Arrays.asList(course1, course2, course3, course4));
        studentList.add(shikha);
        studentList.add(shailja);
        studentList.add(megha);
        studentList.add(pinku);

    }
    @Override
    public List<Student> findStudentById(String id)
    {
        return studentList;
    }

    @Override
    public Student findAllStudent(String studentId) {
        for (Student student:studentList) {
            student.getId().equals(studentId);
       return student;
        }
        return null;
    }

    @Override
    public List<Course> findCourses(String studentId) {
       Student student= findAllStudent(studentId);
       if(student==null){
           return null;
       }
        return student.getCourseList();
    }

    @Override
    public Course findAllCourseDetails(String studentId, String courseId) {
        Student student = findAllStudent(studentId);
        if (student == null) {
            return null;
        }
        for (Course course : student.getCourseList()) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
            return null;
    }

    @Override
    public Course addCourse(String studentId, Course course) {

        return null;
    }
}