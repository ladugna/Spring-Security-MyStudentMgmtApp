package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
@Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student newStudent) {
        return studentRepository.save(newStudent) ;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 3,Sort.by(Sort.Direction.ASC,"firstName")));
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
   studentRepository.deleteById(studentId);

    }

    @Override
    public List<Student> searchStudents(String searchString) {
        return studentRepository.findAllByStudentIdOr_firstName_MiddleName_LastName
                (searchString,searchString,searchString,searchString);
    }


}
