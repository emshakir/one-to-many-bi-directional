package com.ccube.mapping.model;


import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "INSTRUCTOR_ID")
    private Instructor instructor;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", instructor='" + instructor.getFirstName() + " " + instructor.getLastName() +
                "\'}";
    }
}
