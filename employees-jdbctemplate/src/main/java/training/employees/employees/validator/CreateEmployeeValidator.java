package training.employees.employees.validator;

import training.employees.employees.dto.CreateEmployeeCommand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateEmployeeValidator implements ConstraintValidator<ValidCreateEmployee, CreateEmployeeCommand> {

    @Override
    public boolean isValid(CreateEmployeeCommand command, ConstraintValidatorContext context) {
        return command.getYearOfBirth() < 2000 || command.getSalary() > 0;
    }

    @Override
    public void initialize(ValidCreateEmployee constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
