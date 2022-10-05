package training.employees.hello;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "employees")
public class EmployeesProperties {

    private String favouriteColor;

    private String favouriteColor2;
}
