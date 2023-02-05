package edu.miu.cs.cs425.studentmgmt.repository;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentsByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(  String studentNumber,
                                                                            String firstname,
                                                                            String middleName, String lastName);

}
