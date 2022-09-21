package training.employees.employees.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training.employees.employees.validator.ValidCreateEmployee;
import training.employees.employees.validator.ValidName;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidCreateEmployee
public class CreateEmployeeCommand {

    @Schema(description = "The name of the employee", example = "Jack Doe")
    @NotBlank
    @Size(min=3, message = "should be longer than 3 character")
    @ValidName(minUppers = 2)
    private String name;

    @Schema(description = "The year of birth of employee", example = "1970")
    @Min(value = 1900, message = "should be greeter than 1900")
    @Max(value = 2030, message = "should be lower than 2030")
    private int yearOfBirth;

    private int salary;
}
