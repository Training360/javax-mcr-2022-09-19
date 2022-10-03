package training.employees.employees.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import training.employees.employees.dto.*;
import training.employees.employees.entity.Address;
import training.employees.employees.entity.Employee;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    List<EmployeeDto> toDto(List<Employee> employees);

    EmployeeDetailsDto toDto(Employee employee);

    Employee toEntity(CreateEmployeeCommand command);

    Address toEntity(CreateAddressCommand command);

    AddressDto toDto(Address address);
}
