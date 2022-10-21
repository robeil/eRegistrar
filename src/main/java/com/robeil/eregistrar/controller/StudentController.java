package com.robeil.eregistrar.controller;

import com.robeil.eregistrar.model.Student;
import com.robeil.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;


@Controller
@RequestMapping(value = {"/eRegistrar/student"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * displaying all students
     * @return
     */
    @GetMapping(value = {"/list"})
    public ModelAndView listStudents(){
        var students = studentService.getAllStudents();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students",students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    /**
     * Adding new Student
     * @param model
     * @return
     */
    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model){
        var newStudent = new Student();
        model.addAttribute("student",newStudent);
        return "secured/student/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student",student);
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    /**
     * updating student
     * @param studentId
     * @param model
     * @return
     */
    @GetMapping(value = {"/edit/{studentId}"})
    public String displayEditStudentFrom(@PathVariable Long studentId, Model model){
        var student = studentService.findStudentById(studentId);
        if(student != null){
            model.addAttribute("student",student);
            return "/secured/student/edit";
        }
        return "redirect:/eRegistrar/student/list";
    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student",student);
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updateStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    /**
     * deleting student
     * @param studentId
     * @return
     */
    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return "redirect:/eRegistrar/student/list";
    }

}
