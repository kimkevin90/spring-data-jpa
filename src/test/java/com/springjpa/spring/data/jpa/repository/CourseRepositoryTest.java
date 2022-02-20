package com.springjpa.spring.data.jpa.repository;

import com.springjpa.spring.data.jpa.entity.Course;
import com.springjpa.spring.data.jpa.entity.Student;
import com.springjpa.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("JISUB")
                .lastName("LIM")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(8)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecord =
                PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecord).getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();

        // 전체 행 count
        System.out.println("totalElements = " + totalElements);

        // 전체 page count
        System.out.println("totalPages = " + totalPages);

        // page 행
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByCredit =
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,2,Sort.by("title").descending().and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords
                ).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("KIM")
                .build();

        Student student = Student.builder()
                .firstName("dodo")
                .lastName("lee")
                .emailId("dodo@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(2)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}