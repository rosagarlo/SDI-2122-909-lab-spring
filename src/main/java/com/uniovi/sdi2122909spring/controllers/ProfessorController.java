package com.uniovi.sdi2122909spring.controllers;

import com.uniovi.sdi2122909spring.entities.Professor;
import com.uniovi.sdi2122909spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping ("/professor/list")
    public String getList() {
        return professorsService.getProfessors().toString();
    }

    @RequestMapping("/professor/add")
    public String setProfessor(@ModelAttribute Professor professor) {
        professorsService.addProfessor(professor);
        return "Professor " + professor.getId() + " added";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return professorsService.getProfessor(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorsService.deleteProfessor(id);
        return "Ok";
    }
}
