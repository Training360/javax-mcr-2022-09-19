package training.employees.employees.repository;

import org.springframework.stereotype.Repository;
import training.employees.employees.entity.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

// @Repository
public class InMemoryEmployeesRepository {

    private AtomicLong idGenerator = new AtomicLong(0);

    private List<Employee> employees = Collections.synchronizedList(new ArrayList<>(
            List.of(
                    new Employee(idGenerator.incrementAndGet(), "John Doe", 1970),
                    new Employee(idGenerator.incrementAndGet(), "Jane Doe", 1980)
                    ))
    );

    public List<Employee> findAll(Optional<String> prefix) {
        return employees.stream().filter(
                e -> prefix.isEmpty() || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase())
        ).toList();
    }

    public Employee findById(long id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public void save(Employee employee) {
        employee.setId(idGenerator.incrementAndGet());
        employees.add(employee);
    }

    public Employee update(long id, int yearOfBirth) {
        var employee = findById(id);
        employee.setYearOfBirth(yearOfBirth);
        return employee;
    }

    public void delete(long id) {
        employees.removeIf(e -> e.getId() == id);
    }

//    public void deleteAll() {
//        employees.clear();
//    }
}
