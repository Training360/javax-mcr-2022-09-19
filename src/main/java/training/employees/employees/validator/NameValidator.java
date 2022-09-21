package training.employees.employees.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    private int minUppers;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.chars()
                .filter(Character::isUpperCase)
                .count() >= minUppers;
    }

    @Override
    public void initialize(ValidName constraintAnnotation) {
        minUppers = constraintAnnotation.minUppers();
    }
}
