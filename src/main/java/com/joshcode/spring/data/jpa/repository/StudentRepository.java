package com.joshcode.spring.data.jpa.repository;

import com.joshcode.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    public List<Student> findByFirstName(String firstName);
    public  List<Student>findByFirstNameContaining(String name);

    List<Student>findByLastName(String lastName);

    List <Student>findByLastNameNotNull();

    List <Student> findByGuardianName(String guardianName);

   List <Student> findByFirstNameAndLastName(String firstName,
                                             String lastName);
   //JPQL Queries are based on class attributes not the table column
   @Query("select s from Student s where s.emailId = ?1")
   Student getStudentByEmailAddress(String emailId);

  List <Student> deleteStudentById (Long studentId);

   @Query("select s.firstName from Student s where s.emailId = ?1")
   String getStudentFirstNameByEmailAddress(String emailId);

   //Native Query
   @Query(
           value = "SELECT * FROM tbl_students s where s.email_address = ?1",
           nativeQuery = true
   )
   Student getStudentStudentByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT * FROM tbl_students s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Transactional
    @Modifying
    @Query(
            value = "update tbl_students set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String firstName, String emailId);
}
