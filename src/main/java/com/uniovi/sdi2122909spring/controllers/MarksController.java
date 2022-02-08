package com.uniovi.sdi2122909spring.controllers;

import com.uniovi.sdi2122909spring.entities.Mark;
import com.uniovi.sdi2122909spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @Autowired // Inyectar el servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList() {
        return marksService.getMarks().toString();
    }

    @RequestMapping(value="/mark/add", method = RequestMethod.POST) // Se debe especificar la petición si es POST
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "Ok";
    }

    /*@RequestMapping("/mark/details")
    public String getDetail(@RequestParam Long id) { //petición GET y que puede recibir un parámetro id
        return "Getting Details=>" + id;
    }*/

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) { // PathVariable tiene en cuenta solo la posición
        return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "Ok";
    }
}