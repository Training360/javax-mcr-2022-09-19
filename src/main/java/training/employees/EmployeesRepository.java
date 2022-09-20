package training.employees;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeesRepository {

    private List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(1L, "John Doe", 1970),
                    new Employee(2L, "Jane Doe", 1980)
                    )
    );

    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    public Employee findById(long id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }
}
