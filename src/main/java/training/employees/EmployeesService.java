package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeesRepository repository;

    private EmployeeMapper employeeMapper;

    public List<EmployeeDto> listEmployees() {
//        return repository.findAll().stream()
//                .map(e -> new EmployeeDto(e.getId(), e.getName()))
//                .toList();
        return employeeMapper.toDto(repository.findAll());
    }

    public EmployeeDetailsDto findEmployeeById(long id) {
//        var employee = repository.findById(id);
//        return new EmployeeDetailsDto(employee.getId(), employee.getName(), employee.getYearOfBirth());

        return employeeMapper.toDto(repository.findById(id));
    }
}
