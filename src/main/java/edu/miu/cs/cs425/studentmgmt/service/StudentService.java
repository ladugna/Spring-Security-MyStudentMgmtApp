package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface StudentService {



    public Student addNewStudent(Student student);

     public Iterable<Student> getAllStudents();
     public Page<Student> getAllStudentsPaged(int pageNo);
    public abstract Student getStudentById(Long studentId);
    public abstract Student updateStudent(Student student);
    public abstract void deleteStudentById(Long studentId);
    //public abstract void deletePrimaryAddressOfStudent(Integer publisherId);
}
