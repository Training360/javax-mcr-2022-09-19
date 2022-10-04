package training.employees.employees.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import training.employees.employees.dto.EmployeeDetailsDto;

import java.time.LocalDateTime;

@Component
@Aspect
public class UpdateCreatedFieldAspect {

    @AfterReturning(value = "execution(training.employees.employees.dto.EmployeeDetailsDto training.employees.employees.service.EmployeesService.*(..))",
        returning = "employeeDetailsDto")
    public void updateCreatedField(EmployeeDetailsDto employeeDetailsDto) {
        employeeDetailsDto.setCreated(LocalDateTime.now());
    }
}
