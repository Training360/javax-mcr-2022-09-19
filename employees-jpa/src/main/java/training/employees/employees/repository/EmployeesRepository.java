package training.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.employees.employees.entity.Employee;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
