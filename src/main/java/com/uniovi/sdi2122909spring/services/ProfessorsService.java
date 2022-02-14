package com.uniovi.sdi2122909spring.services;

import com.uniovi.sdi2122909spring.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {

    private List<Professor> professorList = new LinkedList<>();

    @PostConstruct
    public void init() {
        professorList.add(new Professor(1L, "6575868L", "Informática"));
        professorList.add(new Professor(2L, "45796892M", "Infraestructuras"));
    }

    public List<Professor> getProfessors() {
        return professorList;
    }

    public Professor getProfessor(Long id) {
        return professorList.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
    }

    public void addProfessor(Professor professor) {
        if (professor.getId() == null) {
            professor.setId(professorList.get(professorList.size() - 1).getId() + 1);
        }
        professorList.add(professor);
    }

    public void deleteProfessor(Long id) {
        professorList.removeIf(professor -> professor.getId().equals(id));
    }
}
