package training.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.employees.employees.dto.EmployeeDto;
import training.employees.employees.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    // JPQL
//    @Query("select e from Employee e where LOWER(e.name) like :prefix")
    List<Employee> findEmployeesByNameLike(String prefix);

    @Query("select new training.employees.employees.dto.EmployeeDto(e.id, e.name) from Employee e")
    List<EmployeeDto> findEmployeeDtos();

    @Query("select new training.employees.employees.dto.EmployeeDto(e.id, e.name) from Employee e where e.name like :prefix")
    List<EmployeeDto> findEmployeeDtosByNameLike(String prefix);

    @Query("select distinct e from Employee e left join fetch e.addresses")
    List<Employee> findEmployeesWithAddresses();

    @Query("select distinct e from Employee e left join fetch e.addresses where e.id = :id")
    Optional<Employee> findEmployeeWithAddresses(long id);
}
