package training.employees;

import org.junit.jupiter.api.Test;
import training.employees.employees.dto.CreateEmployeeCommand;
import training.employees.employees.validator.CreateEmployeeValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateEmployeeValidatorTest {

    @Test
    void testBefore2000() {
        assertTrue(new CreateEmployeeValidator()
                .isValid(new CreateEmployeeCommand("John Doe", 1999, 0),
            null));
    }

    @Test
    void testAfter2000WithFail() {
        assertFalse(new CreateEmployeeValidator()
                .isValid(new CreateEmployeeCommand("John Doe", 2001, 0),
                        null));
    }

    @Test
    void testAfter2000() {
        assertTrue(new CreateEmployeeValidator()
                .isValid(new CreateEmployeeCommand("John Doe", 2001, 100),
                        null));
    }
}
