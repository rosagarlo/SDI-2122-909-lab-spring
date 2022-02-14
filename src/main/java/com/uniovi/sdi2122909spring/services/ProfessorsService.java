package com.uniovi.sdi2122909spring.services;

import com.uniovi.sdi2122909spring.entities.Professor;
import com.uniovi.sdi2122909spring.repositories.MarksRepository;
import com.uniovi.sdi2122909spring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorRepository professorsRepository;

    /*
    @PostConstruct
    public void init() {
        professorList.add(new Professor(1L, "6575868L", "Informática"));
        professorList.add(new Professor(2L, "45796892M", "Infraestructuras"));
    }*/

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id) {
        return professorsRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) {
        // Si es null se le asinga el último +1 de la lista
        professorsRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        professorsRepository.deleteById(id);
    }
}
