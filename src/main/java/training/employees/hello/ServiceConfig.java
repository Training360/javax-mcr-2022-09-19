package training.employees.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.employees.hello.HelloService;
import training.employees.hello.TimeMachine;

@Configuration
public class ServiceConfig {

    @Bean
    public TimeMachine timeMachine() {
        return new TimeMachine();
    }
    @Bean
    public HelloService helloService() {
        return new HelloService(timeMachine());
    }

}
