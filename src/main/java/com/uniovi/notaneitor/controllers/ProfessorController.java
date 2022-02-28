package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping ("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professorsList", professorsService.getProfessors());
        return "professor/list";
    }

    @RequestMapping("/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professorsList", professorsService.getProfessors());
        return "professor/add";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor) {
        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorsService.deleteProfessor(id);
        return "Ok";
    }
}
