package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MarkFormValidator implements Validator {

    @Autowired
    private MarksService marksService;


    @Override
    public boolean supports(Class<?> clazz) {
        return Mark.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
        /*if (mark.getUser().getDni().length() != 9 || !mark.getUser().getDni().substring(8,8).matches("[A-Z]*")) {
            errors.rejectValue("dni", "Error.signup.dni.error");
        }
        if (marksService.getMark(mark.getId()).getUser().getDni() != null) {
            errors.rejectValue("dni", "Error.mark.dni.duplicate");
        }*/
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.mark.score.range");
        }
        if (mark.getDescription().length() < 20) {
            errors.rejectValue("description", "Error.mark.description.length");
        }
    }
}
