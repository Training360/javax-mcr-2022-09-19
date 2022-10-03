package training.employees.hello;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.employees.hello.HelloService;
import training.employees.hello.TimeMachine;

@Configuration
@EnableConfigurationProperties(EmployeesProperties.class)
public class ServiceConfig {

    @Bean
    public TimeMachine timeMachine() {
        return new TimeMachine();
    }
    @Bean
    public HelloService helloService(EmployeesProperties employeesProperties) {
        return new HelloService(timeMachine(), employeesProperties);
    }

}
