package training.employees.employees.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = CreateEmployeeValidator.class)
public @interface ValidCreateEmployee {

    String message() default "invalid employee";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
