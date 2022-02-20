package com.springjpa.spring.data.jpa.repository;

import com.springjpa.spring.data.jpa.entity.Guardian;
import com.springjpa.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("test@gmail.com")
                .firstName("lim")
                .lastName("jisub")
                //.guardianName("Heedo")
                //.guardianEmail("heedo@gmail.com")
                //.guardianMobile("01012345678")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Heedo1")
                .email("heedo1@gmail.com")
                .mobile("01012345678")
                .build();


        Student student = Student.builder()
                .emailId("test1@gmail.com")
                .firstName("lim1")
                .lastName("jisub1")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void  printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("lim1");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("li");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Heedo1");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentFindByFirstNameAndLastName() {
        Student students =
                studentRepository.findByFirstNameAndLastName("lim1", "jisub1");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("test1@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void  printStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("test1@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void  printGetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative("test1@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void  printGetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("test1@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("lim33", "test1@gmail.com");
    }

}