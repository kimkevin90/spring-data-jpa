package com.springjpa.spring.data.jpa.repository;

import com.springjpa.spring.data.jpa.entity.Course;
import com.springjpa.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(11)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(4)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("HEEDO")
                        .lastName("CHE")
//                        .courses(List.of(courseDBA, courseJAVA))
                        .build();

        teacherRepository.save(teacher);
    }
}