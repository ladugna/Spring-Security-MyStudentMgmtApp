package edu.miu.cs.cs425.studentmgmt.controller;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping(value = {"/student", "/eregistrar/student"})
public class StudentController {

private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listPublishers(@RequestParam(defaultValue = "0") int pageNo) {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudentsPaged(pageNo);
        modelAndView.addObject("students", students);
        modelAndView.addObject("currentPageNo", pageNo);
//        modelAndView.addObject("publishersCount", ((List)publishers).size());
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }


    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student(null, null,
                null,null,null,null,null,null,null));
        return "secured/student/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
                                       BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }

        studentService.addNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/eregistrar/student/list";
    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }

        studentService.updateStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

//    @GetMapping(value = {"/primaryAddress/delete/{publisherId}"})
//    public String deletePrimaryAddressOfPublisher(@PathVariable Integer publisherId) {
//        publisherService.deletePrimaryAddressOfPublisher(publisherId);
//        return "redirect:/fairfieldlibrary/publisher/list";
//    }


    @GetMapping(value = {"/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/student/searchResult");
        return modelAndView;
    }


}
