package training.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.employees.employees.entity.Employee;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    // JPQL
    @Query("select e from Employee e where LOWER(e.name) like :prefix")
    List<Employee> findEmployeesByPrefix(String prefix);
}
