package com.jellyfish.app.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Student implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "student")
    private List<Course> courseList;
    //constructor and getter, setter
    public Student() {
    }
    public Student(String id, String name, String description, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseList = courseList;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseList=" + courseList +
                '}';
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Course> getCourseList() {
        return courseList;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}