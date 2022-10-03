package training.employees.employees.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NameValidator.class)
public @interface ValidName {

    String message() default "invalid name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int minUppers() default 1;

}
