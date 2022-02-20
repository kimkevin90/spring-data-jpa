package com.springjpa.spring.data.jpa.repository;

import com.springjpa.spring.data.jpa.entity.Course;
import com.springjpa.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    //Course에 OneToMany적용 시
//    @Test
//    public void SaveCourseMatarial() {
//        Course course = Course.builder()
//                        .title("Network1")
//                        .credit(10)
//                        .build();
//
//        CourseMaterial courseMaterial =
//                CourseMaterial.builder()
//                        .url("www.google1.com")
//                        .course(course)
//                        .build();
//
//        repository.save(courseMaterial);
//    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterialList =
                repository.findAll();

        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}