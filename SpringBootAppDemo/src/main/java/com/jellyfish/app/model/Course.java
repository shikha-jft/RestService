package com.jellyfish.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "studentId")
    private Student student;
    //constructor,getter and setter
    public Course() {
    }
    public Course(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
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
}