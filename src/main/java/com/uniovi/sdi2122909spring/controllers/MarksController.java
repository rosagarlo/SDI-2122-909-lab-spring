package com.uniovi.sdi2122909spring.controllers;

import com.uniovi.sdi2122909spring.entities.Mark;
import com.uniovi.sdi2122909spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MarksController {

    @Autowired // Inyectar el servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST) // Se debe especificar la petición si es POST
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "redirect:/mark/list"; // no existe un fichero "Ok" por lo que se debe redirigir
    }

    @RequestMapping(value = "/mark/add")
    public String getMark() {
        return "mark/add";
    }

    /*@RequestMapping("/mark/details")
    public String getDetail(@RequestParam Long id) { //petición GET y que puede recibir un parámetro id
        return "Getting Details=>" + id;
    }*/

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) { // PathVariable tiene en cuenta solo la posición
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list"; // no existe un fichero "Ok" por lo que se debe redirigir
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        mark.setId(id);
        marksService.addMark(mark);
        return "redirect:/mark/details/" + id;
    }
}