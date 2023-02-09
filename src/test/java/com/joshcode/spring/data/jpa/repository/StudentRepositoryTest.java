package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Guardian;
import com.joshcode.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

@Test
    public void saveStudent(){
    Student student = Student.builder()
            .emailId("rollingmoney@gmail.com")
            .firstName("Joshua")
            .lastName("Gabriel")
//            .guardianName("Olalekan")
//            .guardianEmail("olalekan@gmail.com")
//            .guardianMobile("08185980756")
            .build();

    studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Olalekan Gabriel")
                .email("Josh20Gabriel@gmail.com")
                .mobile("+234559008")
                .build();
    Student student = Student.builder()
            .firstName("John")
            .lastName("Gabriel")
            .emailId("johnGabriel@gmail.com")
            .guardian(guardian)
            .build();

    studentRepository.save(student);
    }

    @Test
    public void findAllStudent(){
    List<Student> studentList = studentRepository.findAll();

        System.out.println("List of all the Student" +studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Joshua");

        System.out.println(" Find student " + students);


    }
//
    @Test
    public void printStudentByFirstNameContaining(){
    List<Student> students = studentRepository.findByFirstNameContaining("Jo");

        System.out.println("List of Student Like or Containing Value or character" +students);
    }

    @Test
    public void printStudentByLastName(){
    List <Student> students = studentRepository.findByLastName("Gabriel");
        System.out.println("Last name name " +students);

    }

    @Test
    public void printStudentBaseOnGuardName() {
        List <Student> students = studentRepository.findByGuardianName("Olalekan");

        System.out.println("Select Student Base on Student guardian" +students);
    }
@Test
    public void printFirstNameAndLastName(){
    List <Student> students = studentRepository.findByFirstNameAndLastName("Joshua","Gabriel");

        System.out.println("Print Student Name with Last Name" +students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
    Student student = studentRepository.getStudentByEmailAddress("rollingmoney@gmail.com");

        System.out.println("Select student by Email Address" +student);
    }

    @Test
    public void  printgetStudentFirstNameByEmailAddress(){
    String students = studentRepository.getStudentFirstNameByEmailAddress("johnGabriel@gmail.com");

        System.out.println("This is the Student FirstName "+students );
    }

    @Test
    public  void printgetStudentStudentByEmailAddressNative(){
    Student student = studentRepository.getStudentStudentByEmailAddressNative("johnGabriel@gmail.com");

        System.out.println("Print select using Native Query" +student);
    }

    @Test
    public  void printgetStudentStudentByEmailAddressNativeNamed(){
        Student student = studentRepository.getStudentStudentByEmailAddressNativeNamedParam("johnGabriel@gmail.com");

        System.out.println("Print select using Native Query" +student);
    }

    @Test
public void updateStudentNameByEmailTest(){
    studentRepository.updateStudentNameByEmail("Peculiar Johnson", "johnGabriel@gmail.com");
}

//@Test
//public void deleteStudentById(){
//
//    Student students = studentRepository.deleteStudentById(1);
//    System.out.println("Delette Student Id " +students);
//
//}
}