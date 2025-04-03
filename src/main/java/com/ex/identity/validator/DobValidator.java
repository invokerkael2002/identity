package com.ex.identity.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
@Slf4j
public class DobValidator implements ConstraintValidator<DobConstrain, LocalDate> {
    private int min;
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        log.warn("validate");
        if(Objects.isNull(localDate))
            return true;
        long years = ChronoUnit.YEARS.between(localDate,LocalDate.now());
        return years >= min;
    }
    @Override
    public void initialize(DobConstrain constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }
}
