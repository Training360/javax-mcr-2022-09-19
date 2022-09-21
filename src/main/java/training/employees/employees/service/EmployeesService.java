package training.employees.employees.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import training.employees.employees.dto.CreateEmployeeCommand;
import training.employees.employees.dto.EmployeeDetailsDto;
import training.employees.employees.dto.EmployeeDto;
import training.employees.employees.dto.UpdateEmployeeCommand;
import training.employees.employees.repository.EmployeesRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeesRepository repository;

    private EmployeeMapper employeeMapper;

    public List<EmployeeDto> listEmployees(Optional<String> prefix) {
//        return repository.findAll().stream()
//                .map(e -> new EmployeeDto(e.getId(), e.getName()))
//                .toList();
        return employeeMapper.toDto(repository.findAll(prefix));
    }

    public EmployeeDetailsDto findEmployeeById(long id) {
//        var employee = repository.findById(id);
//        return new EmployeeDetailsDto(employee.getId(), employee.getName(), employee.getYearOfBirth());

        return employeeMapper.toDto(repository.findById(id));
    }

    public EmployeeDetailsDto createEmployee(CreateEmployeeCommand command) {
        var employee = employeeMapper.toEntity(command);
        repository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public EmployeeDetailsDto updateEmployee(long id, UpdateEmployeeCommand command) {
        var employee = repository.update(id, command.getYearOfBirth());
        return employeeMapper.toDto(employee);
    }

    public void deleteEmployee(long id) {
        repository.delete(id);
    }
}
