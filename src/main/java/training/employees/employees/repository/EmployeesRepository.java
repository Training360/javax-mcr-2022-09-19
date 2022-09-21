package training.employees.employees.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import training.employees.employees.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EmployeesRepository {

    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(Optional<String> prefix) {
        if (prefix.isEmpty()) {
            return jdbcTemplate.query("select id, emp_name, year_of_birth from employees",
                    EmployeesRepository::mapEmployee);
        }
        else {
            return jdbcTemplate.query("select id, emp_name, year_of_birth from employees where emp_name like ?",
                    EmployeesRepository::mapEmployee, prefix.get() + "%");
        }
    }

    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select id, emp_name, year_of_birth from employees where id = ?",
                EmployeesRepository::mapEmployee, id);
    }

    public void save(Employee employee) {
        var keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            var preparedStatement = connection.prepareStatement("insert into employees (emp_name, year_of_birth) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getYearOfBirth());
            return preparedStatement;
        }, keyHolder);

        employee.setId(keyHolder.getKey().longValue());
    }

    public Employee update(long id, int yearOfBirth) {
        jdbcTemplate.update("update employees set year_of_birth = ? where id = ?",
                yearOfBirth, id);
        return findById(id);
    }

    public void delete(long id) {
        jdbcTemplate.update("delete from employees where id = ?",
                id);
    }

//    public void deleteAll() {
//        employees.clear();
//    }

    private static Employee mapEmployee(ResultSet rs, int i) throws SQLException {
        return new Employee(rs.getLong("id"),
                rs.getString("emp_name"),
                rs.getInt("year_of_birth"));
    }

}
