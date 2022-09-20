package training.employees;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateEmployeeCommand {

    @Schema(description = "The name of the employee", example = "Jack Doe")
    private String name;

    @Schema(description = "The year of birth of employee", example = "1970")
    private int yearOfBirth;
}
