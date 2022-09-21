package training.employees.hello;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@Service
@AllArgsConstructor
public class HelloService {

    private TimeMachine timeMachine;

    private EmployeesProperties employeesProperties;

    public String sayHello() {
        return "Hello from devtools service! " + timeMachine.now();
    }

    public String getFavouriteColor() {
        return employeesProperties.getFavouriteColor() + " " + employeesProperties.getFavouriteColor2();
    }
}
