package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import training.employees.employees.dto.EmployeeDto;
import training.employees.employees.entity.Employee;
import training.employees.employees.repository.EmployeesRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeesRepositoryIT {

    @Autowired
    EmployeesRepository repository;

    @Test
    void testCreateEmployee() {
        var employee = new Employee();
        employee.setName("John Doe");
        repository.save(employee);

        var employees = repository.findEmployeeDtosByNameLike("J%");

        assertThat(employees)
                .extracting(EmployeeDto::getName)
                .contains("John Doe");

    }
}
