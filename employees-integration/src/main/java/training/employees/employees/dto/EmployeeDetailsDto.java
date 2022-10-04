package training.employees.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import training.employees.employees.gateway.ExternalAddressDto;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeDetailsDto {

    private Long id;

    private String name;

    private int yearOfBirth;

    private LocalDateTime created;

    private ExternalAddressDto address;
}
