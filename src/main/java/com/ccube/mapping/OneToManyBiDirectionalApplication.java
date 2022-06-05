package com.ccube.mapping;

import com.ccube.mapping.model.*;
import com.ccube.mapping.repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class OneToManyBiDirectionalApplication implements CommandLineRunner {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    public OneToManyBiDirectionalApplication(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OneToManyBiDirectionalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Instructor firstInstructor = new Instructor("Mohammad", "Shakir", "shakir@gmail.com");
        Instructor secondInstructor = new Instructor("Dasari", "Anil", "dasari.anil@gmail.com");

        Course firstCourse = new Course("Java: Complete Reference");
        Course secondCourse = new Course("Oracle: Complete reference");
        Course thirdCourse = new Course("HTML&CSS: complete reference");
        Course fourthCourse = new Course("Elon Musk: Biography");

        firstInstructor.addCourse(firstCourse);
        firstInstructor.addCourse(secondCourse);
        firstInstructor.addCourse(thirdCourse);

        secondInstructor.addCourse(thirdCourse);
//        secondInstructor.addCourse(fourthCourse);
//        secondInstructor.addCourse(secondCourse);

        instructorRepository.save(firstInstructor);
        instructorRepository.save(secondInstructor);
        Optional<Instructor> firstOptIns = instructorRepository.findById(firstInstructor.getId());
        Optional<Instructor> secondOptIns = instructorRepository.findById(secondInstructor.getId());
        List<Course> firstInscourses = firstOptIns.get().getCourses();
        List<Course> SecondInscourses = secondOptIns.get().getCourses();
        for (Course course : firstInscourses) {
            System.out.println(course.toString());
        }
        System.out.println(":::::::::::::::::::::::::");
        for (Course course : SecondInscourses) {
            System.out.println(course.toString());
        }

    }
}
