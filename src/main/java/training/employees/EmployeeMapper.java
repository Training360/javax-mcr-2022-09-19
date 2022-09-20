package training.employees;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    List<EmployeeDto> toDto(List<Employee> employees);

    EmployeeDetailsDto toDto(Employee employee);

    Employee toEntity(CreateEmployeeCommand command);
}
