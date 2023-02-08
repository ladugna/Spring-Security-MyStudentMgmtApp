package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassRoomService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
    @Autowired
private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private ClassRoomService classRoomService;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello spring boot, Student Management app started......");
       


        System.out.println("Bye spring boot, Student Management app is completed......");
    }

//create new student
    private Student addNewStudent(Student student){
        return studentService.addNewStudent(student);
    }

    private Transcript addNewTranscript(Transcript newTranscript){
        return transcriptService.addNewTranscript(newTranscript);
    }
    private Classroom addNewClassRoom(Classroom classroom){
        return classRoomService.addNewClassRoom(classroom);
    }
}
