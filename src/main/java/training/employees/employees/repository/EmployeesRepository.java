package training.employees.employees.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import training.employees.employees.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EmployeesRepository {

    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(Optional<String> prefix) {
        if (prefix.isEmpty()) {
            return jdbcTemplate.query("select id, emp_name from employees",
                    EmployeesRepository::mapEmployee);
        }
        else {
            return jdbcTemplate.query("select id, emp_name from employees where emp_name like :prefix",
                    EmployeesRepository::mapEmployee, prefix.get() + "%");
        }
    }

    private static Employee mapEmployee(ResultSet rs, int i) throws SQLException {
        return new Employee(rs.getLong("id"),
                rs.getString("emp_name"),
                rs.getInt("year_of_birth"));
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
