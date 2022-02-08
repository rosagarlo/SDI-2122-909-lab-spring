package com.uniovi.sdi2122909spring.controllers;

import com.uniovi.sdi2122909spring.entities.Mark;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {
    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
    }

    @RequestMapping(value="/mark/add", method = RequestMethod.POST) // Se debe especificar la petición si es POST
    public String setMark(@ModelAttribute Mark mark) {
        return "Added: " + mark.getDescription()
                + " with score: " + mark.getScore()
                + " id: " + mark.getId();
    }

    /*@RequestMapping("/mark/details")
    public String getDetail(@RequestParam Long id) { //petición GET y que puede recibir un parámetro id
        return "Getting Details=>" + id;
    }*/

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) { // PathVariable tiene en cuenta solo la posición
        return "Getting Details =>" + id;
    }
}